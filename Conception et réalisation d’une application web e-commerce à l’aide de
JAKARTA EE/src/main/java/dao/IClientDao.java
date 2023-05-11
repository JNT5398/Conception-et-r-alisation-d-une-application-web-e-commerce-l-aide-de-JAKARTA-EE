package dao;

import java.util.List;
import metier.entities.Client;

public interface IClientDao {
	public Client save (Client c);
	public List<Client> clientParId(long i);
	public Client getClient(Long id);
	public Client update(Client c);
	public void deleteClient(Long id);
	public Client getClientParE(String email);
}
