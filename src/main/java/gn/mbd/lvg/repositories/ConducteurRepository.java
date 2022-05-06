package gn.mbd.lvg.repositories;

import gn.mbd.lvg.entities.Conducteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
    Page<Conducteur> findByPrenomContains(String keyword, Pageable pageable);
}
