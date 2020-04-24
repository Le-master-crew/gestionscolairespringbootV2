package eu.ensup.gestionscolairespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eu.ensup.gestionscolairespringboot.domaine.Cours;
import eu.ensup.gestionscolairespringboot.domaine.Direction;
import eu.ensup.gestionscolairespringboot.domaine.Etudiant;
import eu.ensup.gestionscolairespringboot.domaine.Personne;
import eu.ensup.gestionscolairespringboot.service.EtudiantService;
import eu.ensup.gestionscolairespringboot.service.IEtudiantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Khady, Benjamin and David
 * Controller contenant les différentes méthodes permettant les interactions service <=> vues
 */
@EnableSwagger2
@Controller
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class StaticController {

	@Autowired
	IEtudiantService ietudiantservice;

	/**
	 * @return
	 */
	@Bean
	public EtudiantService ietudiantservice() {
		return new EtudiantService();
	}

	/**
	 * 
	 */
	public StaticController() {
		super();
	}
	
	/**
	 * @return
	 */
	public IEtudiantService getIetudiantservice() {
		return ietudiantservice;
	}

	/**
	 * @param ietudiantservice
	 */
	public void setIetudiantservice(IEtudiantService ietudiantservice) {
		this.ietudiantservice = ietudiantservice;
	}

	/**
	 * @param iformationService
	 */
	public StaticController(IEtudiantService iformationService) {
		super();
		this.ietudiantservice = iformationService;
	}
	/**
	 * Méthode listant les étudiants
	 * @param model
	 * @return
	 */
	@ApiOperation(value = "View a list of available employees")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@RequestMapping("/listeEtudiants")
	public String listeEtudiants(Model model) {
		System.out.println("entree dans la methode listeEtudiants");
		model.addAttribute("listeEtudiants", ietudiantservice.getAll());
		return "listeEtudiants";
	}

	/**
	 * Méthode listant les cours
	 * @param model
	 * @return
	 */
	@RequestMapping("/listeCours")
	public String listeCours(Model model) {
		System.out.println("entree dans la methode listeEtudiants");
		// model.addAttribute("listeCours", ietudiantservice.getAllCours());
		return "listeCours";
	}

	/**
	 * redirection vers la page d'accueil
	 * @return
	 */
	@RequestMapping("/accueil")
	public String accueil() {
		
		return "accueil";
	}

	/**
	 * paramétrage de la page de lancement de l'application
	 * redirige vers le formulaire de connexion
	 * @return
	 */
	@GetMapping("/")
	public String home() {
		
		return "getFormLogin";
	}

	/**
	 * permet de lier un étudiant à un cours
	 * redirige vers la vue messageAjoutEtudiantCours.jsp
	 * @param etudiant
	 * @param cours
	 * @return
	 */
	@PostMapping("/lierEtudiantCours")
	public String lierEtudiantCours(Etudiant etudiant, Cours cours) {
		System.out.println("entree dans la methode ajouterEtudiant");
		// ietudiantservice.lierCoursEtudiant(etudiant, cours);
		return "messageAjoutEtudiantCours";
	}

	/**
	 * Redirection à la vue ajouterEtudiant.jsp
	 * @return
	 */
	@GetMapping("getFormAjoutEtudiant")
	public String getFormAjoutEtudiant() {
		return "ajouterEtudiant";
	}

	/**
	 * Méthode permettant de sauvegarder un étudiant dans la base en remplissant les différents 
	 * attributs suivant :
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param adresse
	 * @param mail
	 * @param dateNaissance
	 * @param etudiant
	 * @param modelMap
	 * @return
	 * 
	 * Redirige sur la vue listeEtudiants.jsp
	 */
	@PostMapping("/saveEtudiant") // it only support port method
	public String saveEtudiant(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
			@RequestParam("telephone") int telephone, @RequestParam("adresse") String adresse,
			@RequestParam("mail") String mail, @RequestParam("dateNaissance") String dateNaissance, Personne personne,Etudiant etudiant,
			ModelMap modelMap) {
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setAdresse(adresse);
		personne.setTelephone(telephone);
		etudiant.setDateNaissance(dateNaissance);
		//ietudiantservice.savePerson(personne);
		etudiant.setId(personne.getId());
		ietudiantservice.saveStudent(etudiant);
		return "redirect:/listeEtudiants"; 
	}

	/**
	 * @return
	 */
//	@RequestMapping("/")
//	public String getFormLogin() {
//		return "accueil";
//	}

	/**
	 * utilisation de la méthode permettant à un dirigeant de se connecter
	 * Dans le cas où cela réussit, redirection vers accueil.jsp sinon error2.jsp
	 * @param password
	 * @param login
	 * @param direction
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/login") // it only support port method
	public String login(@RequestParam("password") String password, @RequestParam("login") String login,
			Direction direction, ModelMap modelMap) {
		direction.setPassword(password);
		direction.setLogin(login);
		if(ietudiantservice.login(login, password)!=null) {
			return "redirect:/accueil";	
		}else {
			return "error2";
		}
		
	}

	/**
	 * redirige vers la vue searchEtudiant.jsp pour la recherche d'un étudiant 
	 * @return
	 */
	@GetMapping("getFormLireEtudiant")
	public String getFormLireEtudiant() {
		return "searchEtudiant";
	}

	/**
	 * En saisissant l'id d'un étudiant, la méthode getById() récupère l'étudiant en question.
	 * Si l'étudiant existe, il est affiché dans la vue detailEtudiant.jsp
	 * @param id
	 * @param model
	 * @return
	 */
	@PostMapping("/readEtudiant")
	public String readEtudiant(@RequestParam("idEtudiant") int id, Model model) {
		model.addAttribute("etudiant", ietudiantservice.getById(id));
		return "detailEtudiant";
	}

	/**
	 * redirige vers la vue rechercheModificationEtudiant.jsp pour la modification d'un étudiant 
	 * @return
	 */
	@GetMapping("getFormModifierEtudiant")
	public String getFormModifierEtudiant() {
		return "rechercheModificationEtudiant";
	}

	/**
	 * En saisissant l'id d'un étudiant, la méthode getById() récupère l'étudiant en question.
	 * Si l'étudiant existe, il est affiché dans la vue modificationEtudiant.jsp
	 * @param id
	 * @param model
	 * @return
	 */
	@PostMapping("/readUpdateEtudiant") 
	public String readUpdateEtudiant(@RequestParam("idEtudiant") int id, Model model) {
		model.addAttribute("etudiant", ietudiantservice.getById(id));
		return "modificationEtudiant"; 
	}

	/**
	 * l'utilisateur va pouvoir changer les informations affiché de l'étudiant
	 * une fois envoyées et valides, l'utilisateur sera envoyer vers la vue listeEtudiants.jsp
	 * @param idEtudiant
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param adresse
	 * @param mail
	 * @param dateNaissance
	 * @param etudiant
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/udpateEtudiant") // it only support port method
	public String udpateEtudiant(@RequestParam("idEtudiant") int idEtudiant, @RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom, @RequestParam("telephone") int telephone,
			@RequestParam("adresse") String adresse, @RequestParam("mail") String mail,
			@RequestParam("dateNaissance") String dateNaissance, Etudiant etudiant, ModelMap modelMap) {
		etudiant.setId(idEtudiant);
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setAdresse(adresse);
		etudiant.setTelephone(telephone);
		etudiant.setDateNaissance(dateNaissance);
		ietudiantservice.update(etudiant);
		return "redirect:/listeEtudiants"; 
	}

	/**
	 * redirige vers la vue rechercheModificationEtudiant.jsp pour la suppression d'un étudiant
	 * @return 
	 */
	@GetMapping("getFormSupprimerEtudiant")
	public String getFormSupprimerEtudiant() {
		return "suppressionEtudiant";
	}

	/**
	 * En saisissant l'id d'un étudiant, la méthode getById() supprime l'étudiant en question.
	 * Si l'étudiant existe, la vue messageSuppression.jsp est affichée.
	 * @param idEtudiant
	 * @param etudiant
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/deleteEtudiant") // it only support port method
	public String deleteEtudiant(@RequestParam("idEtudiant") int idEtudiant, Etudiant etudiant, ModelMap modelMap) {
		etudiant.setId(idEtudiant);
		ietudiantservice.deleteStudent(etudiant);
		return "messageSuppression"; // welcome is view name. It will call welcome.jsp
	}
}
