package eu.ensup.gestionscolairespringboot.service;

import eu.ensup.gestionscolairespringboot.dao.CoursRepository;
import eu.ensup.gestionscolairespringboot.dao.DirectionRepository;
import eu.ensup.gestionscolairespringboot.dao.EtudiantRepository;
import eu.ensup.gestionscolairespringboot.dao.PersonneRepository;
import eu.ensup.gestionscolairespringboot.domaine.Cours;
import eu.ensup.gestionscolairespringboot.domaine.Direction;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;
import eu.ensup.gestionscolairespringboot.domaine.Personne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EtudiantService implements IEtudiantService {

    //On connecte la dao avec l'auto configuration
    @Autowired
    private EtudiantRepository etudiantDAO;
    @Autowired
    private CoursRepository coursDAO;
    @Autowired
    private DirectionRepository directionDAO;
    @Autowired
    private PersonneRepository personneDAO;

    //Constructeur par défault
    public EtudiantService() {
        super();
    }

   

    public EtudiantService(EtudiantRepository etudiantDAO, CoursRepository coursDAO, DirectionRepository directionDAO, PersonneRepository personneDAO) {
		super();
		this.etudiantDAO = etudiantDAO;
		this.coursDAO = coursDAO;
		this.directionDAO = directionDAO;
		this.personneDAO = personneDAO;
	}



	@Override
    public Personne saveStudent(Etudiant etu) {
		return personneDAO.save(etu);
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
    public void lierCoursEtudiant(Cours cours, Etudiant etudiant) {
        if (etudiantDAO.existsById(etudiant.getId())  && coursDAO.existsById(cours.getIdCours())) {
            etudiantDAO.saveAndFlush(etudiant);
        }
        
    }
    
    @Override
    public Direction login(String login,String password) {
    	Direction direction = new Direction();
        direction = 	directionDAO.findByLoginAndPassword(login, password);
        System.out.println("sysout de direction" + direction);
    	return direction;
    }



	@Override
	public void update(Etudiant etu) {
		personneDAO.save(etu);
		
	}
	
	public List<Cours> getAllCours() {
		
		return coursDAO.findAll();
		
	}

}
