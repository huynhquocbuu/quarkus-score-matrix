package adapters.oracle;

import adapters.oracle.entity.KogitoResult;
import application.port.out.KogitoRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import fico.scoring.decision.vo.KogitoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import lombok.extern.slf4j.Slf4j;
import org.kie.kogito.dmn.rest.KogitoDMNResult;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class KogitoRepoImpl implements KogitoRepo, PanacheRepositoryBase<KogitoResult, Long> {

    @Override
    public KogitoEntity save(final KogitoDMNResult result) {
        log.info(">>> saving KogitoDMNResult");
        try {
            ObjectMapper om = new ObjectMapper();
            String payload = om.writeValueAsString(result);
            var entity = KogitoResult.builder()
                    .payload(payload)
                    .hasError(result.hasErrors() ? 1 : 0)
                    .build();
            persist(entity);
            return new KogitoEntity(Optional.of(entity.getId()), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("<<< saving KogitoDMNResult");
        throw new IllegalArgumentException("cannot persist KogitoResult");
    }
}
