package sn.uasz.demoJPA.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*@ManyToOne
    @JoinColumn(name = "enseignant_id")*/
    private Enseignant enseignant;

    /*@ManyToOne
    @JoinColumn(name = "enseignement_id")*/
    private Enseignement enseignement;

    private String dateModification;

    private boolean validation;

    private String createby;
    private String createat;
}
