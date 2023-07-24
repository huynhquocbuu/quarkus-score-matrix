package adapters.oracle.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "KOGITO_RESULT")
@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class KogitoResult extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
        name = "kogitoResultSeq",
        sequenceName = "SEQ_KOGITO_RESULT_$1",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kogitoResultSeq")
    private Long id;

    @Lob
    @Column(name = "PAYLOAD")
    private String payload;

    @Column(name = "HAS_ERROR")
    private Integer hasError;

    @CreationTimestamp
    @Column(name = "CREATION_TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATED_TIMESTAMP")
    private LocalDateTime updatedAt;
}
