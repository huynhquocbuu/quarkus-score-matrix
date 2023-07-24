package fico.scoring.decision;

import fico.scoring.decision.vo.FactorsVO;
import fico.scoring.decision.vo.KogitoEntity;
import fico.scoring.decision.vo.SegmentVO;
import io.smallrye.mutiny.Uni;
import io.vavr.Function2;
import org.kie.kogito.Application;
import org.kie.kogito.decision.DecisionModels;
import org.kie.kogito.dmn.rest.DMNJSONUtils;
import org.kie.kogito.dmn.rest.KogitoDMNResult;

import java.util.Map;
import java.util.Optional;

public interface KogitoProvider extends KogitoMapper, KogitoRepo, Validator {

    Application application();

    private Function2<Application, Map<String, Object>, KogitoDMNResult> application(String modelname, String namespace) {
        return (a, m) -> {
            var model = a
                .get(DecisionModels.class)
                .getDecisionModel(namespace, modelname);
            var context = DMNJSONUtils.ctx(model, m);
            var result = model.evaluateAll(context);
            return new KogitoDMNResult(namespace, modelname, result);
        };
    }

    private KogitoDMNResult kogitoEval(FactorsVO factors) {
        return this.application(factors.modelname(), factors.namespace())
            .apply(this.application(), factors.vars());
    }

    default Uni<KogitoEntity> uniEval(FactorsVO factors) {
        return Uni
            .createFrom()
            .item(factors)
            .map(this::kogitoEval)
            .map(this::save)
            .flatMap(entity -> {
                if (entity.getId().isEmpty()) {
                    return Uni.createFrom().failure(new IllegalArgumentException("entity is not available, please check your persistence"));
                }
                return Uni.createFrom().item(entity);
            })
            .log("KogitoEntity: ");
    }

    default Uni<SegmentVO> uniEvalSegment(FactorsVO factors) {
        return Uni.createFrom()
            .item(factors)
            .flatMap(this::uniEval)
            .map(this::asSegment)
        ;
    }
}
