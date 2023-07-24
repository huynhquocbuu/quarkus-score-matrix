package fico.scoring.decision.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class MatrixFieldVO {
    String name;
    String type;
    Optional<String> regex;
}
