package sn.uasz.demoJPA.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@DiscriminatorValue(value = "ETUD")
public class Etudiant extends User{
    private String nom;
    private String prenom;
    private String numCarte;
}
