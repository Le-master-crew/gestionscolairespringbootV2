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
import eu.ensup.gestionscolairespringboot.service.EtudiantService;
import eu.ensup.gestionscolairespringboot.service.IEtudiantService;

/**
 * @author Khady, Benjamin and David
 *
 */
@Controller
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

	public IEtudiantService getIetudiantservice() {
		return ietudiantservice;
	}

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
	 * @param model
	 * @return
	 */
	@RequestMapping("/listeEtudiants")
	public String listeEtudiants(Model model) {
		System.out.println("entree dans la methode listeEtudiants");
		model.addAttribute("listeEtudiants", ietudiantservice.getAll());
		return "listeEtudiants";
	}

	/**
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
	 * @return
	 */
	@RequestMapping("/accueil")
	public String accueil() {
		
		return "accueil";
	}

	/**
	 * @return
	 */
	@GetMapping("/")
	public String home() {
		
		return "getFormLogin";
	}

	/**
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
	 * @return
	 */
	@GetMapping("getFormAjoutEtudiant")
	public String getFormAjoutEtudiant() {
		return "ajouterEtudiant";
	}

	/**
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
	@PostMapping("/saveEtudiant") // it only support port method
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
	 * @return
	 */
//	@RequestMapping("/")
//	public String getFormLogin() {
//		return "accueil";
//	}

	/**
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
	 * @return
	 */
	@GetMapping("getFormLireEtudiant")
	public String getFormLireEtudiant() {
		return "searchEtudiant";
	}

	/**
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
	 * @return
	 */
	@GetMapping("getFormModifierEtudiant")
	public String getFormModifierEtudiant() {
		return "rechercheModificationEtudiant";
	}

	/**
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
		//ietudiantservice.udpateStudent(etudiant);
		return "redirect:/listeEtudiants"; 
	}

	/**
	 * @return
	 */
	@GetMapping("getFormSupprimerEtudiant")
	public String getFormSupprimerEtudiant() {
		return "suppressionEtudiant";
	}

	/**
	 * @param idEtudiant
	 * @param etudiant
	 * @param modelMap
	 * @return
	 */
	@PostMapping("/deleteEtudiant") // it only support port method
	public String deleteEtudiant(@RequestParam("idEtudiant") int idEtudiant, Etudiant etudiant, ModelMap modelMap) {
		etudiant.setId(idEtudiant);
		// ietudiantservice.deleteStudent(idEtudiant);
		return "messageSuppression"; // welcome is view name. It will call welcome.jsp
	}
}
