package br.com.compass.uol.pb2022.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PARTY")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Associate> associate;

    @Column(nullable = false)
    private String nameParty;

    @Column(nullable = false)
    private String acronym;

    @Column(nullable = false)
    private String ideology;

    @Column(nullable = false)
    private LocalDate foundingDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Party party = (Party) o;
        return id != null && Objects.equals(id, party.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
