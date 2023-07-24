package application.mapper;

import adapters.rest.request.MatrixRequest;
import application.port.in.data.MatrixData;
import application.port.in.data.Segment;
import fico.scoring.decision.vo.FactorsVO;
import fico.scoring.decision.vo.SegmentVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MatrixMapper {
    MatrixMapper INSTANCE = Mappers.getMapper(MatrixMapper.class);

    @Mapping(source = "modelname", target = "modelname")
    @Mapping(source = "namespace", target = "namespace")
    @Mapping(source = "vars", target = "vars")
    FactorsVO vo(MatrixData source);

    @Mapping(source = "modelname", target = "modelname")
    @Mapping(source = "namespace", target = "namespace")
    @Mapping(source = "vars", target = "vars")
    MatrixData data(MatrixRequest source);

    @Mapping(source = "index", target = "index")
    @Mapping(source = "segment", target = "segment")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "decision", target = "decision")
    Segment segment(SegmentVO source);
}
