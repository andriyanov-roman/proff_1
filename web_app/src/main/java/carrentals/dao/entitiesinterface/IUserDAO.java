package carrentals.dao.entitiesinterface;

import carrentals.entities.User;

public interface IUserDAO {
	public User checkUserLogin(String login, String password);
	public User getUser(Integer idUser);
	public void createUser(User user);
	public void updateUser(User user);

}
