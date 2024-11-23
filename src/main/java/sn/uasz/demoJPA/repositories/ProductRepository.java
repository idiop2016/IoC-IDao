package sn.uasz.demoJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.uasz.demoJPA.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
   public List<Product> findByNameContainsIgnoreCase(String kw);
   @Query("select p from Product p where p.name like %:ac% and p.price>:p")
   public List<Product> search(@Param("ac") String kw, @Param("p")double price);
}
