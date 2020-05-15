package eu.ensup.gestionscolairespringboot.servicetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.service.EtudiantService;

@SpringBootTest
public class ServiceTest {

	@Mock
	EtudiantRepository ietudiantdao;

	@Autowired
	@InjectMocks
	private EtudiantService etudiantService;

	@BeforeEach
	public void setUp() {

	}

	@Test
	void saveStudentTest() {
		
	}

	@Test
	void getAllEtudiantTest() {

	}

	@Test
	void getEtudoantByIdTest() {

	}

	@Test
	void deleteStudentTest() {

	}

	@Test
	void lierCoursEtudiantTest() {

	}

	@Test
	void loginTest() {

	}

	@Test
	void updateTest() {

	}

}
