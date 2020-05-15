package eu.ensup.gestionscolairespringboot.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import eu.ensup.gestionscolairespringboot.dao.CoursRepository;
import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.domaine.Cours;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;
import eu.ensup.gestionscolairespringboot.service.EtudiantService;

class EtudiantServiceTest {

	@Mock
	private EtudiantRepository ietudiantdao;

	@Mock
	private CoursRepository icoursdao;

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

		Mockito.when(ietudiantdao.getOne(7)).thenReturn(etu);
		// 2. Tester le service

		when(ietudiantdao.getOne(7)).thenReturn(etu); // class Mockito importé en static
		// 2. Utiliser le service
		Etudiant found = etudiantService.getById(7);
		// verify(ietudiantdao, times(1)).getOne(7);
		assertEquals("prenom", found.getPrenom());

	}

	@Test
	void getAllEtudiantTest() {
		List<Etudiant> list = new ArrayList<Etudiant>();
		Etudiant etu1 = new Etudiant(7, "nom", "prenom", "mail", "adresse", 123, "dateNaissance");
		Etudiant etu2 = new Etudiant(2, "nom2", "prenom2", "mail2", "adresse2", 123, "dateNaissance2");
		Etudiant etu3 = new Etudiant(3, "nom3", "prenom3", "mail3", "adresse3", 123, "dateNaissance3");

		list.add(etu1);
		list.add(etu2);
		list.add(etu3);

		Mockito.when(ietudiantdao.findAll()).thenReturn(list);

		List<Etudiant> listEtu = etudiantService.getAll();

		assertEquals(3, listEtu.size());
	}

	@Test
	void lierCoursEtudiantTest() {

		Etudiant etu = new Etudiant();
		Cours cours = new Cours();

		etu.setId(1);
		cours.setIdCours(2);

		when(ietudiantdao.existsById(1)).thenReturn(true);
		when(icoursdao.existsById(2)).thenReturn(true);
		when(ietudiantdao.saveAndFlush(etu)).thenReturn(etu);

		assertEquals(etu, etudiantService.lierCoursEtudiant(cours, etu));

	}

    @Test
    void updateTest() {
    	Etudiant etu = new Etudiant();
		Etudiant etu2 = new Etudiant();
		etu2.setPrenom("prenom");
		when(ietudiantdao.save(etu)).thenReturn(etu2);
		assertEquals(etu2, etudiantService.update(etu));
    }

}
