package application.port.in.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class Segment implements Serializable {
    String index;

    String segment;

    String code;

    String decision;


    @JsonGetter("index")
    public String getIndex() {
        return index;
    }

    @JsonSetter("Index")
    public void setIndex(String index) {
        this.index = index;
    }

    @JsonGetter("segment")
    public String getSegment() {
        return segment;
    }

    @JsonSetter("Segment")
    public void setSegment(String segment) {
        this.segment = segment;
    }

    @JsonGetter("code")
    public String getCode() {
        return code;
    }

    @JsonGetter("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonGetter("decision")
    public String getDecision() {
        return decision;
    }

    @JsonSetter("Decision")
    public void setDecision(String decision) {
        this.decision = decision;
    }
}
