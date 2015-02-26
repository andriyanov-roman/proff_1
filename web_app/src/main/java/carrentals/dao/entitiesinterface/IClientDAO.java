package carrentals.dao.entitiesinterface;

import carrentals.entities.Client;

public interface IClientDAO {
	public Client getClient(Integer idUser);
	public void createClient(Client client);
	public void updateClient(Client client);
}
