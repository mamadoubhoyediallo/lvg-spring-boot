package gn.mbd.lvg.restControllers;

import gn.mbd.lvg.entities.Conducteur;
import gn.mbd.lvg.repositories.ConducteurRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
@AllArgsConstructor
public class ConducteurRestController {
    private ConducteurRepository conducteurRepository;

    @RequestMapping(path = "/findAllConducteur", method = RequestMethod.GET)
    List<Conducteur> showAllConducteur(){
       return conducteurRepository.findAll();
    }
    @RequestMapping(value = "/findConducteurById/{id}", method = RequestMethod.GET)
    public Conducteur getConducteurById(@PathVariable Long id){
         return conducteurRepository.findById(id).orElse(null);
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        conducteurRepository.deleteById(id);
    }
    @RequestMapping(value = "saveConducteur", method = RequestMethod.POST)
    public Conducteur save(@RequestBody Conducteur conducteur){
        return conducteurRepository.save(conducteur);
    }
}
