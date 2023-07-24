package application.port.in;


import application.port.MatrixUsecase;
import application.port.out.KogitoRepo;
import fico.scoring.decision.vo.KogitoEntity;
import fico.scoring.decision.vo.MatrixFieldVO;
import org.kie.kogito.Application;
import org.kie.kogito.dmn.rest.KogitoDMNResult;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class MatrixIO implements MatrixUsecase {

    @Inject Application application;

    @Inject KogitoRepo repo;


    @Override
    public Application application() {
        return this.application;
    }

    @Override
    public List<MatrixFieldVO> getFields(String modelname) {
        return new ArrayList<>();
    }

    @Override
    public KogitoEntity save(final KogitoDMNResult result) {
//        return new KogitoEntity(Optional.of(1L), result);
        return repo.save(result);
    }

}
