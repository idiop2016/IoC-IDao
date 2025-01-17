package sn.uasz.demoJPA.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.uasz.demoJPA.entities.Enseignant;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {
    public List<Enseignant> findByNomContainsIgnoreCase(String kw);
    public List<Enseignant> findByPrenomContainsIgnoreCase(String kw);
    public Page<Enseignant> findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase(String kw1, String kw2, Pageable pageable);
}