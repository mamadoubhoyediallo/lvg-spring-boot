package gn.mbd.lvg.restControllers;

import gn.mbd.lvg.entities.FicheDeSortie;
import gn.mbd.lvg.repositories.FicheDeSortieRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class FicheDeSortieRestController {
    private FicheDeSortieRepository ficheDeSortieRepository;

    @RequestMapping(value = "/ficheDeSortie/{idC}", method = RequestMethod.GET)
    List<FicheDeSortie> getFdsByConducteur(@PathVariable Long id){
        return ficheDeSortieRepository.getFdsByConducteur(id);
    }
}
