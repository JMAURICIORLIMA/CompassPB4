package br.com.compass.uol.pb2022.repository;

import br.com.compass.uol.pb2022.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    @Query(value = "SELECT true FROM TB_PARTY WHERE acronym LIKE %?1%", nativeQuery = true)
    Optional<Boolean> checkAcronym (@Param("acronym") String acronym);

    String findByAcronymLike(String acronym);

    List<Party> findByIdeology(String ideology);

    Optional<Party> findById(Long id);

    String findByNameParty(String nameParty);
}
