package eu.ensup.gestionscolairespringboot.dao;


import eu.ensup.gestionscolairespringboot.domaine.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Integer>{

}
