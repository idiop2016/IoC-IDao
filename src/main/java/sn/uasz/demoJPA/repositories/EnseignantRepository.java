package sn.uasz.demoJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.uasz.demoJPA.entities.Enseignant;
import sn.uasz.demoJPA.entities.Product;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {
    //public List<Enseignant> findByNameContainsIgnoreCase(String kw);
    public List<Enseignant> findByPrenomContainsIgnoreCase(String kw);
}
