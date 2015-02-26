package carrentals.controller.commands;

import carrentals.controller.PagePath;
import carrentals.dao.DAOFactory;
import carrentals.dao.entitiesinterface.ICarDAO;
import carrentals.dao.entitiesinterface.IClientDAO;
import carrentals.dao.entitiesinterface.IPlaceDAO;
import carrentals.entities.Car;
import carrentals.entities.Client;
import carrentals.entities.Place;
import carrentals.entities.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class OrderCommand implements ICommand {
    private static Logger logger = Logger.getLogger(OrderCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String idCar = request.getParameter("idcar");
        /**
         * This method use Database Access Object to get car and places
         * from database with entered parameters
         */
        DAOFactory factory = DAOFactory.getDAOFactory();
        ICarDAO carDAO = factory.getCarDAO();
        Integer numberIdCar = Integer.parseInt(idCar);
        Car car = carDAO.getCar(numberIdCar);
        IPlaceDAO placeDAO = factory.getPlaceDAO();
        Place placeGet = placeDAO.getPlace(car.getIdPlace());
        request.setAttribute("car", car);
        request.setAttribute("place", placeGet);
        ArrayList<Place> listPlaces = placeDAO.getListPlaceSortedByCity();
        Place[] places = new Place[listPlaces.size()];
        places = listPlaces.toArray(places);
        request.setAttribute("places", places);
        IClientDAO clientDAO = factory.getClientDAO();
        if ((request.getSession().getAttribute("ID")) == null) {
            User user = new User();
            request.getSession().setAttribute("role", user.getRole());
            request.getSession().setAttribute("ID", user.getId());
        }
        Client client = clientDAO.getClient((Integer) request.getSession().getAttribute("ID"));
        request.setAttribute("client", client);

        logger.info("Redirection to the order page");

        String page = PagePath.ORDER_PAGE_PATH;
        return page;
    }

}
