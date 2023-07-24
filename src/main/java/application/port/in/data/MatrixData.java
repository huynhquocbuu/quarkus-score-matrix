package application.port.in.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class MatrixData {
    String namespace;
    String modelname;
    Map<String, Object> vars;
}
