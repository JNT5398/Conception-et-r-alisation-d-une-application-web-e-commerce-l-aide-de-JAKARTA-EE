package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import metier.entities.Fornisseur;


public class FornisseurDaoImpl implements IFornisseurDao{

	@Override
	public Fornisseur save(Fornisseur f) {
		Connection connection = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO fornisseur (Nom_Fornisseur, Tele_Fornisseur, Addresse_Fornisseur) VALUES (?, ?, ?);");
			ps.setString(1, f.getNom_Fornisseur());
			ps.setInt(2, f.getTele_Fornisseur());
			ps.setString(3, f.getAdresse_Fornisseur());
			
			
			ps.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement
					("SELECT MAX(Id_Fornisseur) as max_id from fornisseur");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				f.setId_Fornisseur(rs.getInt("max_id"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Fornisseur> fornisseurParId(String i) {
		List<Fornisseur> fornisseurs = new ArrayList<Fornisseur>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT *FROM fornisseur WHERE Nom_Fornisseur LIKE ?");
			ps.setString(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Fornisseur f = new Fornisseur();
				
				f.setId_Fornisseur(rs.getInt(1));
				f.setNom_Fornisseur(rs.getString(2));
				f.setTele_Fornisseur(rs.getInt(3));
				f.setAdresse_Fornisseur(rs.getString(4));
				
				fornisseurs.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fornisseurs;
	}
	
	

	@Override
	public Fornisseur fornisseurParS(String i) {
		Fornisseur f = new Fornisseur();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT *FROM fornisseur WHERE Nom_Fornisseur LIKE ?");
			ps.setString(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				f.setId_Fornisseur(rs.getInt(1));
				f.setNom_Fornisseur(rs.getString(2));
				f.setTele_Fornisseur(rs.getInt(3));
				f.setAdresse_Fornisseur(rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public Fornisseur getFornisseur(int id) {
		Fornisseur f = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT *FROM fornisseur WHERE Id_Fornisseur = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				f = new Fornisseur();
				f.setId_Fornisseur(rs.getInt(1));
				f.setNom_Fornisseur(rs.getString(2));
				f.setTele_Fornisseur(rs.getInt(3));
				f.setAdresse_Fornisseur(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public Fornisseur update(Fornisseur f) {
Connection connection = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE fornisseur SET Nom_Fornisseur = ?, Tele_Fornisseur = ?, Addresse_Fornisseur = ? WHERE Id_Fornisseur = ?;");
			ps.setString(1, f.getNom_Fornisseur());
			ps.setInt(2, f.getTele_Fornisseur());
			ps.setString(3, f.getAdresse_Fornisseur());
			ps.setInt(4, f.getId_Fornisseur());
			
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public void deleteFornisseur(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM fornisseur WHERE Id_Fornisseur = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
