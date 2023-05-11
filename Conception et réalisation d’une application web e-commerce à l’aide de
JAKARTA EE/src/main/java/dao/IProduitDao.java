package dao;

import java.util.List;

import metier.entities.Produit;

public interface IProduitDao {
	public Produit save (Produit p);
	public List<Produit> produitParId(String mc);
	public List<Produit> produitId(long i);
	public List<Produit> produitFornisseurParId(int i);
	public List<Produit> getProduit();
	public Produit getProduit(Long id);
	public Produit update(Produit p);
	public void deleteProduit(Long id);
}
