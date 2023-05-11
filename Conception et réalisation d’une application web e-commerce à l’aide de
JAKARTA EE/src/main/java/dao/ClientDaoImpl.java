package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Client;

public class ClientDaoImpl implements IClientDao {

	@Override
	public Client save(Client c) {
		
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO client (Nom_Client, Prenom_Client, Adresse_Client, Email_Client, NumeroTele_Client, PassWord_Client) VALUES (?,?,?,?,?,?);");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getAdresse());
			ps.setString(4, c.getEmail());
			ps.setLong(5, c.getTele());
			ps.setString(6, c.getPassword());
			ps.executeUpdate();
			PreparedStatement ps2=connection.prepareStatement
					("select  MAX(Id_Client) as max_id from client" );
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				c.setId(rs.getLong("max_id"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Client> clientParId(long i) {
		List<Client> clients = new ArrayList<Client>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM client WHERE Id_Client=?");
			ps.setLong(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Client c=new Client();
				c.setId(rs.getLong(1));
				c.setNom(rs.getString(2));
				c.setPrenom(rs.getString(3));
				c.setAdresse(rs.getString(4));
				c.setEmail(rs.getString(5));
				c.setTele(rs.getLong(6));
				c.setPassword(rs.getString(7));
				
				clients.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public Client getClient(Long id) {
		Client c= null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM client WHERE Id_Client=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c=new Client();
				c.setId(rs.getLong(1));
				c.setNom(rs.getString(2));
				c.setPrenom(rs.getString(3));
				c.setAdresse(rs.getString(4));
				c.setEmail(rs.getString(5));
				c.setTele(rs.getLong(6));
				c.setPassword(rs.getString(7));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Client update(Client c) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE client SET Nom_Client=?, Prenom_Client=?, Adresse_Client=?, Email_Client=?, NumeroTele_Client=?, PassWord_Client=? WHERE Id_Client = ?;");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getAdresse());
			ps.setString(4, c.getEmail());
			ps.setLong(5, c.getTele());
			ps.setString(6, c.getPassword());
			ps.setLong(7, c.getId());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM client WHERE Id_Client = ?");
			ps.setLong(1,id);
			ps.executeUpdate();
			ps.close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Client getClientParE(String email) {
		Client client = new Client();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select *from client where Email_Client = ?");
		    ps.setString(1, email);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next()) {
		    	client.setId(rs.getLong(1));
		    	client.setNom(rs.getString(2));
		    	client.setPrenom(rs.getString(3));
		    	client.setAdresse(rs.getString(4));
		    	client.setEmail(rs.getString(5));
		    	client.setTele(rs.getLong(6));
		    	client.setPassword(rs.getString(7));
		    }
		    ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

}
