package adapters.oracle.entity;

import io.quarkus.hibernate.orm.panache.Panache;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "MATRIX_DECISION")
public class MatrixDecision extends Panache  {
    @Column(name = "INDEX")
    private String index;

    @Column(name = "SEGMENT")
    private String Segment;

    @Column(name = "DECISION")
    private String decision;

    @Column(name = "CODE")
    private String code;

    @Column(name = "HAS_ERROR")
    private String error;

    @Column(name = "ERROR_MESSAGE")
    private String error_message;

    @Column(name = "KOGITO_RESULT", nullable = false)
    private String kogitoResult;

    @CreationTimestamp
    @Column(name = "CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATED_TIMESTAMP")
    private LocalDateTime updateAt;
}
