package sn.uasz.demoJPA.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private String grade;
    private String createby;
    private String createat;
    @OneToMany
    private List<Choix> choixes;
}
