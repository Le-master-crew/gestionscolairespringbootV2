package eu.ensup.gestionscolairespringboot.service;

import java.util.List;

import eu.ensup.gestionscolairespringboot.domaine.Cours;
import eu.ensup.gestionscolairespringboot.domaine.Direction;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;

public interface IEtudiantService {

    public Etudiant saveStudent(Etudiant etu);
    public List<Etudiant> getAll();
    public Etudiant getById(int id);
    public void deleteStudent(Etudiant etudiant);
    public Etudiant lierCoursEtudiant(Cours cours, Etudiant etudiant);
    Direction login(String login, String password);
    public Etudiant update(Etudiant etu);
    public List<Cours> getAllCours();

}