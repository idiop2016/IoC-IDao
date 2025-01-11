package sn.uasz.demoJPA.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@DiscriminatorValue(value = "PROF")
public class Enseignant extends User{

    private String nom;
    private String prenom;
    private String matricule;
    private String grade;
    private String createby;
    private String createat;
    @OneToMany
    private List<Choix> choixes;

}
