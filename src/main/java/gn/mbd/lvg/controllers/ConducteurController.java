package gn.mbd.lvg.controllers;

import gn.mbd.lvg.entities.Conducteur;
import gn.mbd.lvg.repositories.ConducteurRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class ConducteurController {
    private ConducteurRepository conducteurRepository;

    @GetMapping(path = "/listeConducteur")
    public String listeConducteur(Model model,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "5") int size,
                                  @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Conducteur> pageConducteurs = conducteurRepository.findByPrenomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listConducteur", pageConducteurs.getContent());
        model.addAttribute("pages", new int[pageConducteurs.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "listeConducteur";
    }
    @GetMapping(path = "/conducteurAdd")
    public String saveForm(Model model){
        model.addAttribute("conducteur", new Conducteur());
        return "addConducteur";
    }
    @PostMapping(path = "/save")
    public String save(Model model, @Valid Conducteur conducteur, BindingResult bindingResult,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "keyword", defaultValue = "") String keyword){
        if (bindingResult.hasErrors()) return "addConducteur";
        conducteurRepository.save(conducteur);
        return "redirect:listeConducteur?page="+page+"&keyword="+keyword;
    }
    @GetMapping(path = "/delete")
    public String delete(Long id){
        conducteurRepository.deleteById(id);
        return "redirect:listeConducteur";
    }
    @GetMapping(path = "/conducteurEdit")
    public String editForm(Model model, Long id, String keyword, int page){
        Conducteur conducteur = conducteurRepository.findById(id).orElse(null);
        if (conducteur==null) throw new RuntimeException("Coducteur introuvable");
        model.addAttribute("conducteur", conducteur);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "editConducteur";
    }
}
