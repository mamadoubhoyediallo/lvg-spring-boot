package gn.mbd.lvg.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class FicheDeSortie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String lieuDepart;
    private String lieuDestination;
    private int nombreLitre;
    @ManyToOne
    private Vehicule vehicule;
    @ManyToOne
    private Conducteur conducteur;
}
