package sn.uasz.demoJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.uasz.demoJPA.entities.Prof;

import java.util.List;

public interface ProfRepository extends JpaRepository<Prof,Long> {
    public List<Prof> findByNameContainsIgnoreCase(String kw);
}
