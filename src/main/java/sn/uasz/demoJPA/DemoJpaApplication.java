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
	@Autowired
	EnseignantRepository enseignantRepository;
/*
	public DemoJpaApplication(EnseignantRepository enseignantRepository) {
		this.enseignantRepository = enseignantRepository;
	}
*/

	public static void main(String[] args) {

		SpringApplication.run(DemoJpaApplication.class, args);
	}


	@Override
	public void run(String... args) {

		enseignantRepository.save(new Enseignant(null,"Diop","Ibrahima","181185/D","Professeur Assimulé",null,null, null));
		enseignantRepository.save(new Enseignant(null,"Fall","Modou","181186/A","Vacataire",null,null, null));
		enseignantRepository.save(new Enseignant(null,"Ndiaye","Ibrahima","181187/B","Vacataire",null,null, null));

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

