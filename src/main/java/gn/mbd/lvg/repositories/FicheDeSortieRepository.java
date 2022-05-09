package gn.mbd.lvg.repositories;

import gn.mbd.lvg.entities.Conducteur;
import gn.mbd.lvg.entities.FicheDeSortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FicheDeSortieRepository extends JpaRepository<FicheDeSortie, Long> {
    @Query("select fds from FicheDeSortie fds where fds.conducteur = ?1")
    List<FicheDeSortie> getFdsByConducteur(@Param("id") Long id);
}
