package fico.scoring.decision.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.kie.kogito.dmn.rest.KogitoDMNResult;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class KogitoEntity {
    Optional<Long> id;
    KogitoDMNResult result;

    @Override
    public String toString() {
        return this.result.toString();
    }
}
