package fico.scoring.decision;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fico.scoring.decision.vo.KogitoEntity;
import fico.scoring.decision.vo.SegmentVO;
import org.kie.kogito.dmn.rest.KogitoDMNResult;

import java.io.Serializable;

public interface KogitoMapper {

    default <T extends Serializable> T as(KogitoDMNResult source, Class<T> type) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(source.getDmnContext(), type);
    }

    default SegmentVO asSegment(KogitoEntity source) {
        var segment = this.as(source.getResult(), SegmentVO.class);
        segment.setId(source.getId());
        return segment;
    }
}
