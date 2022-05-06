package gn.mbd.lvg.controllers;

import gn.mbd.lvg.entities.Conducteur;
import gn.mbd.lvg.entities.FicheDeSortie;
import gn.mbd.lvg.entities.Vehicule;
import gn.mbd.lvg.repositories.ConducteurRepository;
import gn.mbd.lvg.repositories.FicheDeSortieRepository;
import gn.mbd.lvg.repositories.VehiculeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class FicheDeSortieController {
    private FicheDeSortieRepository ficheDeSortieRepository;
    private VehiculeRepository vehiculeRepository;
    private ConducteurRepository conducteurRepository;

    @GetMapping(path = "/addFicheDeSortie")
    public String saveForm(Model model){
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        List<Conducteur> conducteurs = conducteurRepository.findAll();
        model.addAttribute("fds", new FicheDeSortie());
        model.addAttribute("vehicule", vehicules);
        model.addAttribute("conducteur", conducteurs);
        return "addFicheDeSortie";
    }
    @PostMapping(path = "/ficheDeSortieSave")
    public String saveFicheDeSortie(Model model, FicheDeSortie ficheDeSortie){
        ficheDeSortieRepository.save(ficheDeSortie);
        return "redirect:listeFicheDeSortie";
    }
    @GetMapping(path = "/listeFicheDeSortie")
    public String listeFicheDeSortie(Model model){
        List<FicheDeSortie> ficheDeSorties = ficheDeSortieRepository.findAll();
        model.addAttribute("fds", ficheDeSorties);
        return "listeFicheDeSortie";
    }
}
