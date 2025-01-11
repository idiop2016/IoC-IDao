package sn.uasz.demoJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.uasz.demoJPA.entities.Etudiant;

import java.beans.JavaBean;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
