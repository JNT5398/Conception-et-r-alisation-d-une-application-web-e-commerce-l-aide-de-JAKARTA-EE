 package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Client;

public class ClientModel {
	private long motCle;
	private List<Client> client = new ArrayList<Client>();
	public long getMotCle() {
		return motCle;
	} 
	public List<Client> getClient() {
		return client;
	}
	public void setClient(List<Client> client) {
		this.client = client;
	}
	public void setMotCle(long motCle) {
		this.motCle = motCle;
	}
}
