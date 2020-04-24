package eu.ensup.gestionscolairespringboot.domaine;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author benja
 * Classe Direction h�ritant de la classe Personne
 */
@Entity
public class Direction extends Personne {

	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Direction(String nom, String prenom, String mail, String adresse, int telephone) {
		super(nom, prenom, mail, adresse, telephone);
	}
	
	public Direction(String nom, String prenom, String mail, String adresse, int telephone, String login,
			String password) {
		super(nom, prenom, mail, adresse, telephone);
		this.login = login;
		this.password = password;
	}
	
	public Direction(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public Direction() {
		super();
	}
}
