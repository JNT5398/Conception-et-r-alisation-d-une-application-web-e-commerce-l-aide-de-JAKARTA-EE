package metier.entities;

import java.io.Serializable;

public class Admin implements Serializable{
	private int id;
	private String Login;
	private String Password;
	
	public Admin() {
		super();
	}
	public Admin(String login, String password) {
		super();
		Login = login;
		Password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
