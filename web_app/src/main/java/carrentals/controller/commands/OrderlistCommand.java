package carrentals.controller.commands;

import carrentals.controller.PagePath;
import carrentals.dao.DAOFactory;
import carrentals.dao.entitiesinterface.IOrderDAO;
import carrentals.entities.Order;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class OrderlistCommand implements ICommand {
    private static Logger logger = Logger.getLogger(OrderlistCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        /**
         * This method use Database Access Object to get list cars from database
         */
        DAOFactory factory = DAOFactory.getDAOFactory();
        IOrderDAO orderDAO = factory.getOrderDAO();
        ArrayList<Order> listOrder = orderDAO.getListOrderSortedByID();
        request.setAttribute("orders", listOrder);

        logger.info("Redirection to the order list page for Administrator");

        String page = PagePath.ORDERLIST_PAGE_PATH;
        return page;
    }

}
