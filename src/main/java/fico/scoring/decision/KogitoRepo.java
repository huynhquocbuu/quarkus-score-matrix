package fico.scoring.decision;

import fico.scoring.decision.vo.KogitoEntity;
import org.kie.kogito.dmn.rest.KogitoDMNResult;


public interface KogitoRepo {
    KogitoEntity save(KogitoDMNResult result);
}
