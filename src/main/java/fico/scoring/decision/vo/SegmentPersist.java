package fico.scoring.decision.vo;

import org.kie.kogito.dmn.rest.KogitoDMNResult;

public class SegmentPersist {
    SegmentVO segment;
    KogitoDMNResult result;

    public SegmentPersist(SegmentVO segment, KogitoDMNResult result) {
        this.segment = segment;
        this.result = result;
    }
}
