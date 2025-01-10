package sn.uasz.demoJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.uasz.demoJPA.entities.Enseignant;
import sn.uasz.demoJPA.repositories.EnseignantRepository;

import java.util.List;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {
	/*@Autowired
	ProductRepository productRepository;*/
	@Autowired
	EnseignantRepository enseignantRepository;
/*
	public DemoJpaApplication(EnseignantRepository enseignantRepository) {
		this.enseignantRepository = enseignantRepository;
	}*/
	//EnseignantRepository enseignantRepository;

	public static void main(String[] args) {

		SpringApplication.run(DemoJpaApplication.class, args);
	}
/*
	@Override
	public void run(String... args) {

		productRepository.save(new Product(null, "ordinateur",123000,45));
		productRepository.save(new Product(null, "scanner",120000,12));
		productRepository.save(new Product(null, "imprimante",150000,40));


		List<Product> products = productRepository.findAll("imp");
		List<Product> products = productRepository.findByNameContains("imp");
		List<Product> products = productRepository.findByNameContainsIgnoreCase("IMP");

		//List<Product> products = productRepository.findByNameContainsIgnoreCase("IMP");
		//List<Product> products = productRepository.findAll();
		//List<Product> products = productRepository.search("imp",120000);
		products.forEach(product -> {
			System.out.println("--------------------");
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getQuantity());
		});
	}*/

	@Override
	public void run(String... args) {

		enseignantRepository.save(new Enseignant(null,"Diop","Ibrahima","181185/D","Professeur Assimulé"));
		enseignantRepository.save(new Enseignant(null,"Fall","Modou","181186/A","Vacataire"));
		enseignantRepository.save(new Enseignant(null,"Ndiaye","Ibrahima","181187/B","Vacataire"));

		List<Enseignant> enseignents = enseignantRepository.findAll();
		//List<Enseignant> enseignents = enseignantRepository.findAll();
		enseignents.forEach(enseignant -> {
			System.out.println("--------------------");
			System.out.println(enseignant.getPrenom());
			System.out.println(enseignant.getNom());
			System.out.println(enseignant.getMatricule());
			System.out.println(enseignant.getGrade());
		});
	}
}

