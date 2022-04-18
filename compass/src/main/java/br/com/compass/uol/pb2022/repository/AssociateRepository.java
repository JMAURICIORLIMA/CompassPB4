package br.com.compass.uol.pb2022.repository;

import br.com.compass.uol.pb2022.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long> {

    @Override
    Optional<Associate> findById(Long aLong);
}
