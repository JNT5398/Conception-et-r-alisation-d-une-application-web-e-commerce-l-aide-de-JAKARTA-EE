package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Fornisseur;
public class FornisseurModel {
	private String motCle;
	private List<Fornisseur> Fornisseur = new ArrayList<Fornisseur>();
	private Fornisseur f = new Fornisseur();
	
	public Fornisseur getF() {
		return f;
	}
	public void setF(Fornisseur f) {
		this.f = f;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Fornisseur> getFornisseur() {
		return Fornisseur;
	}
	public void setFornisseur(List<Fornisseur> fornisseur) {
		Fornisseur = fornisseur;
	}
	
}