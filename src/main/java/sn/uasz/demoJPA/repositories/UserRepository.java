package sn.uasz.demoJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.uasz.demoJPA.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
}
