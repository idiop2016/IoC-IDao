package sn.uasz.demoJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.uasz.demoJPA.entities.Enseignant;
import sn.uasz.demoJPA.entities.Etudiant;
import sn.uasz.demoJPA.entities.User;
import sn.uasz.demoJPA.repositories.EnseignantRepository;
import sn.uasz.demoJPA.repositories.EtudiantRepository;
import sn.uasz.demoJPA.repositories.UERepository;
import sn.uasz.demoJPA.repositories.UserRepository;

import java.util.List;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {
	@Autowired
	EnseignantRepository enseignantRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
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

		Enseignant enseignant1 = new Enseignant();
		enseignant1.setNom("Diop");
		enseignant1.setPrenom("Ibrahima");
		enseignant1.setMatricule("181185/D");
		enseignant1.setGrade("Professeur Assimulé");
		enseignant1.setEmail("ibbra.dsk@gmail.com");
		enseignant1.setPassword("passer");
		enseignantRepository.save(enseignant1);
		Enseignant enseignant2 = new Enseignant();
		enseignant2.setNom("Fall");
		enseignant2.setPrenom("Modou");
		enseignant2.setMatricule("181185/D");
		enseignant2.setGrade("Vacataire");
		enseignant2.setEmail("ibbra.dsk@gmail.com");
		enseignant2.setPassword("passer");
		enseignantRepository.save(enseignant2);
		Enseignant enseignant3 = new Enseignant();
		enseignant3.setNom("Ndiaye");
		enseignant3.setPrenom("Ibrahima");
		enseignant3.setMatricule("181185/D");
		enseignant3.setGrade("Vacataire");
		enseignant3.setEmail("ibbra.dsk@gmail.com");
		enseignant3.setPassword("passer");
		enseignantRepository.save(enseignant3);
		Etudiant etudiant1 = new Etudiant();
		etudiant1.setNom("Sana");
		etudiant1.setPrenom("Ibrahima");
		etudiant1.setNumCarte("181185/D");
		etudiant1.setEmail("sna.dsk@gmail.com");
		etudiant1.setPassword("passer");
		etudiantRepository.save(etudiant1);

		List<Enseignant> users1 = enseignantRepository.findAll();

		users1.forEach(user -> {
			System.out.println("--------------------");
			System.out.println(user.getPrenom());
			System.out.println(user.getNom());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getMatricule());
			System.out.println(user.getGrade());
		});

		List<Etudiant> users2 = etudiantRepository.findAll();

		users2.forEach(user -> {
			System.out.println("--------------------");
			System.out.println(user.getPrenom());
			System.out.println(user.getNom());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getNumCarte());
		});
	}
}

