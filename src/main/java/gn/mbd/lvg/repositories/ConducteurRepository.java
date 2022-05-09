package gn.mbd.lvg.repositories;

import gn.mbd.lvg.entities.Conducteur;
import gn.mbd.lvg.entities.FicheDeSortie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
    Page<Conducteur> findByPrenomContains(String keyword, Pageable pageable);
}
