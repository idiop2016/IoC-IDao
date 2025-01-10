package sn.uasz.demoJPA.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class UE {
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

    @OneToMany
    private List<EC> ecs;

    private String createby;
    private String createat;
}

