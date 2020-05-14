package eu.ensup.gestionscolairespringboot.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;
import eu.ensup.gestionscolairespringboot.service.EtudiantService;

class EtudiantServiceTest {

	@Mock
	private EtudiantRepository ietudiantdao;

	@Autowired
	@InjectMocks
	private EtudiantService etudiantService;

	// write test cases here

	@BeforeEach
	public void setupMock() {
		MockitoAnnotations.initMocks(this); // Cette méthode initialise également les objets simulés lors de
											// l'initialisation des tests junit.
	}

	@Test
	void saveStudentTest() {
		Etudiant etu = new Etudiant();
		Etudiant etu2 = new Etudiant();
		etu.setPrenom("test");
		when(ietudiantdao.save(etu)).thenReturn(etu2);
		assertEquals(etu2, etudiantService.saveStudent(etu));
	}

	@Test
	void LireEtudiantTest() {
		Etudiant etu = new Etudiant(7, "nom", "prenom", "mail", "adresse", 123, "dateNaissance");
		// 1. Imposer un comportement à notre mock (dao)
		when(ietudiantdao.getOne(7)).thenReturn(etu); // class Mockito importé en static
		// 2. Utiliser le service
		Etudiant found = etudiantService.getById(7);
		// verify(ietudiantdao, times(1)).getOne(7);
		assertEquals("prenom", found.getPrenom());

	}

//    @Test
//    void getAllEtudiantTest() {
//    	
//    }
//    
//    @Test
//    void getEtudiantByIdTest() {
//    	
//    }
//    
//    
//    @Test
//    void lierCoursEtudiantTest() {
//    	
//    }
//    
//    @Test
//    void loginTest() {
//    	
//    }
//    
//    @Test
//    void updateTest() {
//    	
//    }

}
