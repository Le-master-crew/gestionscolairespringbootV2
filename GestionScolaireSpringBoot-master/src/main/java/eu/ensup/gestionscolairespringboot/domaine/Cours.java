package eu.ensup.gestionscolairespringboot.domaine;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author benja
 * Classe Cours
 */
@Entity
public class Cours {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCours;
	private String libelle;
	private int nbHeure;
	@ManyToMany(mappedBy = "cours")
	private List<Etudiant> etudiants = new ArrayList();
	
	
	public int getIdCours() {
		return idCours;
	}
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getNbHeure() {
		return nbHeure;
	}
	public void setNbHeure(int nbHeure) {
		this.nbHeure = nbHeure;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public Cours(String libelle, int nbHeure, List<Etudiant> etudiants) {
		super();
		this.libelle = libelle;
		this.nbHeure = nbHeure;
		this.etudiants = etudiants;
	}
	public Cours() {
		super();
	}
	
	public Cours(String libelle, int nbHeure) {
		super();
		this.libelle = libelle;
		this.nbHeure = nbHeure;
	}
}
