package gn.mbd.lvg.repositories;

import gn.mbd.lvg.entities.Vehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    Page<Vehicule> findByImmatriculationContains(String keyword, Pageable pageable);
}
