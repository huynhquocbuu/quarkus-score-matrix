package fico.scoring.decision.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class DataContext {
    String modelname;
    String namespace;
    Map<String, Object> vars;
}
