package sn.uasz.demoJPA.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    private String type;

   /* @ManyToOne
    @JoinColumn(name = "ue_id")*/
    private UE ue;

/*    @ManyToOne
    @JoinColumn(name = "ec_id")*/
    private EC ec;

//    @OneToMany
    private Choix choix;

    private String createby;
    private String createat;
}
