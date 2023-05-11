package metier.entities;

import java.io.Serializable;

public class Fornisseur implements Serializable{
	private int id_Fornisseur;
	private String nom_Fornisseur;
	private int tele_Fornisseur;
	private String adresse_Fornisseur;
	
	public int getId_Fornisseur() {
		return id_Fornisseur;
	}

	public void setId_Fornisseur(int id_Fornisseur) {
		this.id_Fornisseur = id_Fornisseur;
	}

	public String getNom_Fornisseur() {
		return nom_Fornisseur;
	}

	public void setNom_Fornisseur(String nom_Fornisseur) {
		this.nom_Fornisseur = nom_Fornisseur;
	}

	public int getTele_Fornisseur() {
		return tele_Fornisseur;
	}

	public void setTele_Fornisseur(int tele_Fornisseur) {
		this.tele_Fornisseur = tele_Fornisseur;
	}

	public String getAdresse_Fornisseur() {
		return adresse_Fornisseur;
	}

	public void setAdresse_Fornisseur(String adresse_Fornisseur) {
		this.adresse_Fornisseur = adresse_Fornisseur;
	}
	
	public Fornisseur(String nom_Fornisseur, int tele_Fornisseur, String adresse_Fornisseur) {
		super();
		this.nom_Fornisseur = nom_Fornisseur;
		this.tele_Fornisseur = tele_Fornisseur;
		this.adresse_Fornisseur = adresse_Fornisseur;
	}

	public Fornisseur() {
		super();
	}
	
}
