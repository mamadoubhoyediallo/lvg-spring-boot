package gn.mbd.lvg;

import gn.mbd.lvg.entities.Conducteur;
import gn.mbd.lvg.repositories.ConducteurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class LvgApplicationTests {
    @Autowired
    ConducteurRepository conducteurRepository;

    @Test
    void addConducteur() {
        Conducteur conducteur = new Conducteur();
        conducteur.setNom("Souare");
        conducteur.setPrenom("Binta");
        conducteur.setDateNaissance(new Date());
        conducteur.setTelephone(709456053);
        conducteur.setAdresse("dakar sacre coeur");
        conducteurRepository.save(conducteur);
    }
    /*@Test
    void listeConducteur(){
        List<Conducteur> conducteurs = conducteurRepository.findAll();
        for (Conducteur conducteur:conducteurs) {
            System.out.println(conducteur.getId()+" "+conducteur.getNom()+" "+conducteur.getPrenom()+" "+conducteur.getDateNaissance()+" "+conducteur.getAdresse()+" "+conducteur.getTelephone());
        }
    }
    @Test
    void findByIdConducteur(){
        Conducteur conducteur = conducteurRepository.findById(1L).get();
        System.out.println(conducteur);
    }*/

}
