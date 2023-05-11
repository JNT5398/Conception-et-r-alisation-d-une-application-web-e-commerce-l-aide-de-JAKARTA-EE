package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitModel {
	private String motCle;
	private List<Produit> produit = new ArrayList<Produit>();
	public long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMotCle() {
		return motCle;
	} 
	public List<Produit> getProduit() {
		return produit;
	}
	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
}
