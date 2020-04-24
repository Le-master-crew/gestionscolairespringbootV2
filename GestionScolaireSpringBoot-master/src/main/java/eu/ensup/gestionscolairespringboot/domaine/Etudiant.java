/**
 * 
 */
package eu.ensup.gestionscolairespringboot.domaine;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;


/**
 * @author benja
 * Classe Etudiant h�ritant de la classe Personne
 */

@Entity
public class Etudiant extends Personne {

	private String dateNaissance;
	@ManyToMany
	private List<Cours> cours = new ArrayList();
	
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public List<Cours> getCours() {
		return cours;
	}
	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}
	
	public Etudiant(String nom, String prenom, String mail, String adresse, int telephone, String dateNaissance,
			List<Cours> cours) {
		super(nom, prenom, mail, adresse, telephone);
		this.dateNaissance = dateNaissance;
		this.cours = cours;
	}
	
	public Etudiant(String nom, String prenom, String mail, String adresse, int telephone, String dateNaissance) {
		super(nom, prenom, mail, adresse, telephone);
		this.dateNaissance = dateNaissance;
	}
	
	public Etudiant(int id, String nom, String prenom, String mail, String adresse, int telephone, String dateNaissance,
			List<Cours> cours) {
		super(id, nom, prenom, mail, adresse, telephone);
		this.dateNaissance = dateNaissance;
		this.cours = cours;
	}
	
	
	public Etudiant(int id, String nom, String prenom, String mail, String adresse, int telephone,
			String dateNaissance) {
		super(id, nom, prenom, mail, adresse, telephone);
		this.dateNaissance = dateNaissance;
	}
	
	public Etudiant() {
		super();
	}
}
