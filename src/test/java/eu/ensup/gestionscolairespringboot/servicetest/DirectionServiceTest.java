package eu.ensup.gestionscolairespringboot.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import eu.ensup.gestionscolairespringboot.dao.DirectionRepository;
import eu.ensup.gestionscolairespringboot.domaine.Direction;
import eu.ensup.gestionscolairespringboot.service.EtudiantService;

class DirectionServiceTest {

	@Mock
	private DirectionRepository idirectiondao;

	@Autowired
	@InjectMocks
	private EtudiantService etudiantService;

	@BeforeEach
	public void setupMock() {
		MockitoAnnotations.initMocks(this); // Cette méthode initialise également les objets simulés lors de
											// l'initialisation des tests junit.
	}

	
	@Test
	void loginTest() {
		Direction direction = new Direction();
		direction.setLogin("login");
		direction.setPassword("pwd");
		when(idirectiondao.findByLoginAndPassword("login","pwd")).thenReturn(direction);
		assertEquals(direction, etudiantService.login("login","pwd"));
	}

}
