package carrentals.dao;


import carrentals.dao.entitiesdao.*;

public abstract class DAOFactory {
	public abstract CarDAO getCarDAO();
	public abstract ClientDAO getClientDAO();
	public abstract OrderDAO getOrderDAO();
	public abstract PlaceDAO getPlaceDAO();
	public abstract UserDAO getUserDAO();
	
	public static DAOMySQL getDAOFactory(){
		return new DAOMySQL();
	}
}
