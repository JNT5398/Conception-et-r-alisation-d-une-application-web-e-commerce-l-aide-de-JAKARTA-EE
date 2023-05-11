package metier.entities;

import java.io.Serializable;

public class Client implements Serializable {
	private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String password;
	private Long tele;
	
	
	public Client(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public Client(String nom, String prenom, String adresse, String email, Long tele, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.tele = tele;
		this.password = password;
	}
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email
				+ ", password=" + password + ", tele=" + tele + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTele() {
		return tele;
	}
	public void setTele(Long tele) {
		this.tele = tele;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
