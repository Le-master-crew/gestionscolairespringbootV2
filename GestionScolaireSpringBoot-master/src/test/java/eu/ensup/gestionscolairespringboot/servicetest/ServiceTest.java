package eu.ensup.gestionscolairespringboot.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;
import eu.ensup.gestionscolairespringboot.service.EtudiantService;
import eu.ensup.gestionscolairespringboot.service.IEtudiantService;


//@RunWith(GestionscolairespringbootApplicationTests.class)
public class ServiceTest {
 
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public IEtudiantService etudiantService() {
            return new EtudiantService();
        }
    }
 
    @Autowired
    private EtudiantService etudiantService;
 
    @MockBean
    private EtudiantRepository ietudiantdao;
 
    // write test cases here
    
    @BeforeEach
    public void setUp() {
        Etudiant etu = new Etudiant(7, "nom", "prenom", "mail", "adresse", 123, "dateNaissance");
     
        //Mockito.when(ietudiantdao.findById(7)).thenReturn(etu);
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
