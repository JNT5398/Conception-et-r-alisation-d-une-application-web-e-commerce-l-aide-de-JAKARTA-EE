package dao;

import java.util.List;

import metier.entities.Fornisseur;


public interface IFornisseurDao {
	public Fornisseur save (Fornisseur f);
	public List<Fornisseur> fornisseurParId(String i);
	public Fornisseur fornisseurParS(String i);
	public Fornisseur getFornisseur(int id);
	public Fornisseur update(Fornisseur f);
	public void deleteFornisseur(int id);
}
