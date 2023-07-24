package fico.scoring.decision;


import fico.scoring.decision.vo.FactorsVO;
import fico.scoring.decision.vo.FieldErrorVO;
import fico.scoring.decision.vo.MatrixFieldVO;
import io.smallrye.mutiny.Uni;
import io.vavr.control.Validation;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface Validator {

    List<MatrixFieldVO> getFields(String modelname);

    default
    <M extends Map<String, Object>>
    Function<M, Validation<List<FieldErrorVO>, M>> validWith(List<MatrixFieldVO> fields) {
        return (m) -> {
            var errors = fields
                .stream()
                .filter(field -> !m.containsKey(field.getName()))
                .map(f -> new FieldErrorVO(f.getName(), f.getName() + " is required"))
                .toList();
            return errors.isEmpty() ? Validation.valid(m) : Validation.invalid(errors);
        };
    }

    default
    <M extends Map<String, Object>>
    Uni<Function<M, Validation<List<FieldErrorVO>, M>>> uniValidWith(String modelname) {
        return Uni.createFrom()
            .item(modelname)
            .map(this::getFields)
            .map(this::validWith);
    }

    default
    Uni<FactorsVO> validate(FactorsVO factors) {
        return this.uniValidWith(factors.modelname())
            .map(f -> f.apply(factors.vars()))
            .flatMap(valid -> {
                if (valid.isInvalid()) {
                    return Uni.createFrom().failure(new IllegalArgumentException(""));
                }
                return Uni.createFrom().item(new FactorsVO(factors.namespace(), factors.modelname(), valid.get()));
            });
    }
}
