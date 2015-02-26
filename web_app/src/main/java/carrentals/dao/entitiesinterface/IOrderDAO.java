package carrentals.dao.entitiesinterface;


import carrentals.entities.Order;

import java.util.ArrayList;

public interface IOrderDAO {
	public void createOrder(Order order);
	public ArrayList<Order> getListOrderSortedByID();
	public void updateOrder(Order order);
	
	
}
