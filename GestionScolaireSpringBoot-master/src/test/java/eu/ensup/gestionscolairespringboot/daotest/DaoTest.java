package eu.ensup.gestionscolairespringboot.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;

@SpringBootTest
class DaoTest {
	// pas test unitaire pour la couche DAO
	// --> test d'intégration --> utiliser une bdd java (plus maléable)
	// + ne polue pas la bdd 
	// test de la couche DAO avec des stub

	@Autowired
	@Mock
	private EtudiantRepository ietudiantdao;
	
	@BeforeEach
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void createShouldReturnTrue() {
		// insert un etudiant en bdd dont le prénom est "test" et asserte que le prenom
		// de l'étudiant correspond à la valeur "test"
		Etudiant etu = new Etudiant();
		etu.setPrenom("test");
		ietudiantdao.save(etu);
		//when(ietudiantdao.save(etu).getPrenom()).thenReturn("test");
		assertEquals("test", ietudiantdao.save(etu).getPrenom());
	}

	@Test
	void readShouldReturnTrue() {
		// lit un étudiant en bdd et asserte que le prenom de l"étudiant lu
		fail();
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