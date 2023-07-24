package application.port;

import application.mapper.MatrixMapper;
import application.port.in.data.MatrixData;
import application.port.in.data.Segment;
import fico.scoring.decision.KogitoProvider;
import io.smallrye.mutiny.Uni;
import org.mapstruct.factory.Mappers;


public interface MatrixUsecase extends KogitoProvider {
    MatrixMapper mapper = Mappers.getMapper(MatrixMapper.class);

    default Uni<Segment> evaluate(MatrixData data) {
        return Uni.createFrom().item(data)
            .map(mapper::vo)
            .flatMap(this::uniEvalSegment)
            .map(mapper::segment);
    }
}
