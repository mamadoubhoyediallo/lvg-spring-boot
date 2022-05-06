package gn.mbd.lvg.controllers;

import gn.mbd.lvg.entities.Vehicule;
import gn.mbd.lvg.repositories.VehiculeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class VehiculeController {
    private VehiculeRepository vehiculeRepository;

    @GetMapping(path = "/listeVehicule")
    public String listeVehicule(Model model,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "5") int size,
                                @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Vehicule> listeVehicule = vehiculeRepository.findByImmatriculationContains(keyword, PageRequest.of(page, size));
        model.addAttribute("vehicule", listeVehicule.getContent());
        model.addAttribute("pages", new int[listeVehicule.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "listeVehicule";
    }
    @GetMapping(path = "/addVehicule")
    public String saveForm(Model model){
        model.addAttribute("vehicule", new Vehicule());
        return "addVehicule";
    }
    @PostMapping("/saveVehicule")
    public String saveVehicule(Vehicule vehicule){
        vehiculeRepository.save(vehicule);
        return "redirect:listeVehicule";
    }
    @GetMapping(path = "/deleteVehicule")
    public String delete(Long id){
        vehiculeRepository.deleteById(id);
        return "redirect:listeVehicule";
    }
    @GetMapping(path = "/")
    public String home(){
        return "home";
    }
}

