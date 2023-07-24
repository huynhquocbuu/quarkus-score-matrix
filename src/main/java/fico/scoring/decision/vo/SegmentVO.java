package fico.scoring.decision.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SegmentVO implements Serializable {
    @JsonIgnore
    Optional<Long> id;  // reference id from kogito result persisted

    @JsonProperty("Index")
    String index;

    @JsonProperty("Segment")
    String segment;

    @JsonProperty("RejectCode")
    String code;

    @JsonProperty("Decision")
    String decision;
}
