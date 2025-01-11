package sn.uasz.demoJPA.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class EC {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    private int credits;
    private int coef;
    private int cm;
    private int td;
    private int tp;
    private int tpe;
    private  String semestre;

    @ManyToOne
    /*@JoinColumn(name = "ue_id")*/
    private UE ue;

    @OneToMany
    private List<Enseignement> enseignements;

    private String createby;
    private String createat;
}

