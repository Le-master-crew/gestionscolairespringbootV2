package eu.ensup.gestionscolairespringboot.dao;


import eu.ensup.gestionscolairespringboot.domaine.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{
    
     public Etudiant save(Etudiant etu);
     public List<Etudiant> findAll();
     public Etudiant getById(int id);
     public void delete(Etudiant etu);

    

}
