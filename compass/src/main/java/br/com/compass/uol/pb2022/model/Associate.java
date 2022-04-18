package br.com.compass.uol.pb2022.model;

import br.com.compass.uol.pb2022.listEnum.AssociatesEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "TB_ASSOCIATE")
public class Associate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Member name required.")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Political position required.")
    private AssociatesEnum politicalPosition;

    @Column(nullable = false)
    @NotNull(message = "Member gender required.")
    private String sex;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(nullable = false)
    @NotNull(message = "Member's date of birth required.")
    private LocalDate brithDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parties_id", nullable = true)
    private Party parties;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Associate associate = (Associate) o;
        return id != null && Objects.equals(id, associate.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

