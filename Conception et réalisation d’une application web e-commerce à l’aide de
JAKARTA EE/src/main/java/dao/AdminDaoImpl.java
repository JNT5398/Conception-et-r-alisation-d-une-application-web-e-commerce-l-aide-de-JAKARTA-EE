package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.entities.Admin;

public class AdminDaoImpl implements IAdminDao{

	@Override
	public Admin getAdmin(String lg) {
		Admin a = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("select *from administrateur where Login = ?");
			ps.setString(1, lg);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new Admin();
				a.setId(rs.getInt(1));
				a.setLogin(rs.getString(2));
				a.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
