package adapters.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class MatrixRequest {
    String modelname;
    String namespace;
    Map<String, Object> vars;
}
