package adapters.oracle.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "V_MATRIX_DECISION_CONFIG")
@Immutable
public class VModelConfig extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAMESPACE")
    private String namespace;

    @Column(name = "FILE_NAME")
    private String filename;

    @Column(name = "LOCATION_PATH")
    private String locationPath;

    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

    @Column(name = "ACTIVE")
    private Integer active;

    @Column(name = "FIELD_NAME")
    private String fieldName;

    @Column(name = "FIELD_TYPE")
    private String fieldType;

    @Column(name = "REGEX_VALIDATION")
    private String regexValidation;

    public static java.util.List<VModelConfig> loadConfig(String alias) {
        return list("alias", alias);
    }
}
