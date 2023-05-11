package metier.entities;

import java.io.Serializable;

public class Produit implements Serializable{
	private Long id;
	private String nom ;
	private double prix;
	private int quantite;
	private String image;
	private int id_Fornisseur;
	private int id_Categorie;
	
	public int getId_Fornisseur() {
		return id_Fornisseur;
	}
	public void setId_Fornisseur(int id_Fornisseur) {
		this.id_Fornisseur = id_Fornisseur;
	}
	public int getId_Categorie() {
		return id_Categorie;
	}
	public void setId_Categorie(int id_Categorie) {
		this.id_Categorie = id_Categorie;
	}
	public Produit() {
		super();
	}
	public Produit(String nom, double prix, int quantite, String image, int id_Fornisseur, int id_Categorie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.image = image;
		this.id_Fornisseur = id_Fornisseur;
		this.id_Categorie = id_Categorie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
