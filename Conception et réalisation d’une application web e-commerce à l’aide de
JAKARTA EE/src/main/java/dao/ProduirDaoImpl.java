package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import metier.entities.Produit;

public class ProduirDaoImpl implements IProduitDao{
    
	
	@Override
	public Produit save(Produit p) {
		
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO produit  (Nom_Produit, Prix_Produit, Quantite_Produit, Image_Produit, Id_Fornisseur, Id_Categorie) VALUES (?,?,?,?,?,?);");
			ps.setString(1, p.getNom());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setString(4, p.getImage());						
			ps.setInt(5, p.getId_Fornisseur());
			ps.setInt(6, p.getId_Categorie());
			
			ps.executeUpdate();
			
			PreparedStatement ps2=connection.prepareStatement
					("select  MAX(Id_Produit) as max_id from produit" );
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getLong("max_id"));
			}
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitParId(String mc) {
		List<Produit> produits = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM produit WHERE Nom_Produit LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p =new Produit();
				p.setId(rs.getLong(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				
				p.setImage(rs.getString(5));
				
				p.setId_Fornisseur(rs.getInt(6));
				p.setId_Categorie(rs.getInt(7));
				
				produits.add(p);
	        }
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return produits;
	}
	
	@Override
	public List<Produit> produitId(long i) {
		List<Produit> produits = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM produit WHERE Id_Produit=?");
			ps.setLong(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p =new Produit();
				p.setId(rs.getLong(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				
				p.setImage(rs.getString(5));
				
				p.setId_Fornisseur(rs.getInt(6));
				p.setId_Categorie(rs.getInt(7));
				
				produits.add(p);
	        }
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return produits;
	}
	
	@Override
	public List<Produit> produitFornisseurParId(int i) {
		List<Produit> produits = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT Id_Produit, Nom_Produit, Prix_Produit, Quantite_Produit, Image_Produit, Id_Categorie FROM produit WHERE Id_Fornisseur = ?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p =new Produit();
				p.setId(rs.getLong(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				p.setImage(rs.getString(5));
				p.setId_Categorie(rs.getInt(6));
			
				produits.add(p);
	        }
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return produits;
	}
	

	@Override
	public List<Produit> getProduit() {
		List<Produit> produits = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT Id_Produit, Nom_Produit, Prix_Produit, Quantite_Produit, Image_Produit  FROM produit");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p =new Produit();
				p.setId(rs.getLong(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				p.setImage(rs.getString(5));
				
				produits.add(p);
	        }
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return produits;
	}

	@Override
	public Produit getProduit(Long id) {
		Produit p= null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM produit WHERE Id_Produit=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p =new Produit();
				p.setId(rs.getLong(1));
				p.setNom(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				p.setImage(rs.getString(5));
				p.setId_Fornisseur(rs.getInt(6));
				p.setId_Categorie(rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit update(Produit p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE produit SET Nom_Produit=?, Prix_Produit=?, Quantite_Produit=?, Image_Produit=?, Id_Fornisseur=?, Id_Categorie=? WHERE Id_Produit=?;");
	
			ps.setString(1, p.getNom());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setString(4, p.getImage());
			ps.setInt(5, p.getId_Fornisseur());
			ps.setInt(6, p.getId_Categorie());
			ps.setLong(7, p.getId());
			
			ps.executeUpdate();
             
			ps.close();
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return p;
	}

	@Override
	public void deleteProduit(Long id) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM produit WHERE Id_Produit = ?");
			ps.setLong(1,id);
			ps.executeUpdate();
			ps.close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
