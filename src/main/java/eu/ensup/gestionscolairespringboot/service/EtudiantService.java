package eu.ensup.gestionscolairespringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eu.ensup.gestionscolairespringboot.dao.CoursRepository;
import eu.ensup.gestionscolairespringboot.dao.DirectionRepository;
import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.domaine.Cours;
import eu.ensup.gestionscolairespringboot.domaine.Direction;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;


public class EtudiantService implements IEtudiantService {

	// On connecte la dao avec l'auto configuration
	@Autowired
	private EtudiantRepository etudiantDAO;
	@Autowired
	private CoursRepository coursDAO;
	@Autowired
	private DirectionRepository directionDAO;

	// Constructeur par défault
	public EtudiantService() {
		super();
	}

	@Override
	public Etudiant saveStudent(Etudiant etu) {
		return etudiantDAO.save(etu);
	}

	@Override
	public List<Etudiant> getAll() {
		return etudiantDAO.findAll();
	}

	@Override
	public Etudiant getById(int id) {
		return etudiantDAO.getOne(id);
	}

	@Override
	public void deleteStudent(Etudiant etudiant) {
		etudiantDAO.delete(etudiant);
	}

	@Override
	public Etudiant lierCoursEtudiant(Cours cours, Etudiant etudiant) {
		if (etudiantDAO.existsById(etudiant.getId()) && coursDAO.existsById(cours.getIdCours())) {
			return etudiantDAO.saveAndFlush(etudiant);
		} else return null;

	}

	@Override
	public Direction login(String login, String password) {
		Direction direction = new Direction();
		direction = directionDAO.findByLoginAndPassword(login, password);
		System.out.println("sysout de direction" + direction);
		return direction;
	}

	@Override
	public Etudiant update(Etudiant etu) {
		return etudiantDAO.save(etu);
	}

	public List<Cours> getAllCours() {

		return coursDAO.findAll();

	}

}
