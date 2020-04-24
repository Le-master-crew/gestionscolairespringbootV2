package eu.ensup.gestionscolairespringboot.daotest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;

@SpringBootTest
class DaoTest {
	// test de la couche DAO avec des stub

	@Autowired
	private EtudiantRepository ietudiantdao;

	@Test
	void createShouldReturnTrue() {
		// insert un etudiant en bdd dont le prénom est "test" et asserte que le prenom
		// de l'étudiant correspond à la valeur "test"
		Etudiant etu = new Etudiant();
		etu.setPrenom("test");
		assertThat(ietudiantdao.save(etu).getPrenom()).isEqualTo("test");
	}

	@Test
	void readShouldReturnTrue() {
		// lit un étudiant en bdd et asserte que le prenom de l"étudiant lu
		
	}

	@Test
	void updateShouldReturnTrue() {
		fail();
	}

	@Test
	void deleteShouldReturnTrue() {
		fail();
	}

}
