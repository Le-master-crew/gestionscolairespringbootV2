package eu.ensup.gestionscolairespringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.ensup.gestionscolairespringboot.domaine.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
