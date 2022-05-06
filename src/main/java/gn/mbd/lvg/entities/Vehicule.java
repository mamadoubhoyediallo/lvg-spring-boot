package gn.mbd.lvg.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String modele;
    private String immatriculation;
    @OneToMany(mappedBy = "vehicule")
    private List<FicheDeSortie> ficheDeSorties  = new ArrayList<>();
}
