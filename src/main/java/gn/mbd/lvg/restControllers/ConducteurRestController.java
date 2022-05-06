package gn.mbd.lvg.restControllers;

import gn.mbd.lvg.entities.Conducteur;
import gn.mbd.lvg.repositories.ConducteurRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@AllArgsConstructor
public class ConducteurRestController {
    private ConducteurRepository conducteurRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<Conducteur> showAllConducteur(){
       return conducteurRepository.findAll();
    }
}
