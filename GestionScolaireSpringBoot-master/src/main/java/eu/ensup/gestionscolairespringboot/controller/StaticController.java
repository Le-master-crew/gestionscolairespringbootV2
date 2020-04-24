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
@Api(value="Système de gestion scolaire", description="Opérations en rapport avec le Système de gestion scolaire")
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
	@ApiOperation(value = "Vue de la liste des étudiants")
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
	@ApiOperation(value = "Vue de la liste des cours")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@RequestMapping("/listeCours")
	public String listeCours(Model model) {
		System.out.println("entree dans la methode listeEtudiants");
		//model.addAttribute("listeCours", ietudiantservice.getAllCours());
		return "listeCours";
	}

	/**
	 * redirection vers la page d'accueil
	 * @return
	 */
	@ApiOperation(value = "Redirection à la vue accueil")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@RequestMapping("/accueil")
	public String accueil() {
		
		return "accueil";
	}

	/**
	 * paramétrage de la page de lancement de l'application
	 * redirige vers le formulaire de connexion
	 * @return
	 */

	

	@ApiOperation(value = "Vue de la page login, vue par défaut lors du lancement de l'applicaiton")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@GetMapping({"/","getFormLogin"})
	public String home() {
		
		return "getFormLogin";
	}
	
	@GetMapping("getFormAjoutEtudiantCours")
	public String getFormAjoutEtudiantCourst() {
		return "ajouterEtudiantCours";
	}

	/**
	 * permet de lier un étudiant à un cours
	 * redirige vers la vue messageAjoutEtudiantCours.jsp
	 * @param etudiant
	 * @param cours
	 * @return
	 */
	@ApiOperation(value = "Vue de liant un étudiant à un cours")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@PostMapping("/lierEtudiantCours")
	public String lierEtudiantCours(Etudiant etudiant, Cours cours) {
		System.out.println("entree dans la methode ajouterEtudiant");
		ietudiantservice.lierCoursEtudiant(cours, etudiant);
		return "messageAjoutEtudiantCours";
	}

	/**
	 * Redirection à la vue ajouterEtudiant.jsp
	 * @return
	 */
	@ApiOperation(value = "Vue de la liste ajout d'un étudiants")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
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
	@ApiOperation(value = "Sauvegarde d'un étudiant")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@PostMapping("/saveEtudiant")
	public String saveEtudiant(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom,
			@RequestParam("telephone") int telephone, @RequestParam("adresse") String adresse,
			@RequestParam("mail") String mail, @RequestParam("dateNaissance") String dateNaissance, Etudiant etudiant,
			ModelMap modelMap) {
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setAdresse(adresse);
		etudiant.setTelephone(telephone);
		etudiant.setDateNaissance(dateNaissance);
		ietudiantservice.saveStudent(etudiant);
		return "redirect:/listeEtudiants"; 
	}


	/**
	 * utilisation de la méthode permettant à un dirigeant de se connecter
	 * Dans le cas où cela réussit, redirection vers accueil.jsp sinon error2.jsp
	 * @param password
	 * @param login
	 * @param direction
	 * @param modelMap
	 * @return
	 */
	@ApiOperation(value = "Authentification d'un dirigeant")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
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
	@ApiOperation(value = "Vue de la recherche d'un étudiant pour étudiant détail")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
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
	@ApiOperation(value = "Lire un �tudiant")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@PostMapping("/readEtudiant")
	public String readEtudiant(@RequestParam("idEtudiant") int id, Model model) {
		model.addAttribute("etudiant", ietudiantservice.getById(id));
		return "detailEtudiant";
	}

	/**
	 * redirige vers la vue rechercheModificationEtudiant.jsp pour la modification d'un étudiant 
	 * @return
	 */
	@ApiOperation(value = "Recherche un �tudiant pour modifier celui-ci")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
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
	@ApiOperation(value = "Lire un �tudiant modifi�")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
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
	@ApiOperation(value = "Modifier un �tudiant")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
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
	@ApiOperation(value = "Rechercher un �tudiant pour supprimer celui-ci")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
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
	@ApiOperation(value = "Supprimer un �tudiant")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@PostMapping("/deleteEtudiant") // it only support port method
	public String deleteEtudiant(@RequestParam("idEtudiant") int idEtudiant, Etudiant etudiant, ModelMap modelMap) {
		etudiant.setId(idEtudiant);
		ietudiantservice.deleteStudent(etudiant);
		return "messageSuppression"; // welcome is view name. It will call welcome.jsp
	}
}
