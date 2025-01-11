package sn.uasz.demoJPA.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Enseignant enseignant;

    @ManyToOne
    private Enseignement enseignement;

    private String dateModification;

    private boolean validation;

    private String createby;

    private String createat;
}
