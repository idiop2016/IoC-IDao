package sn.uasz.demoJPA.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    private String type;

    @ManyToOne
    private EC ec;

    @OneToMany
    private List<Choix> choixes;

    private String createby;
    private String createat;
}
