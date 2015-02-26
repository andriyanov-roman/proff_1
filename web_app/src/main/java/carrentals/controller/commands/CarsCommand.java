package carrentals.controller.commands;

import carrentals.controller.PagePath;
import carrentals.dao.DAOFactory;
import carrentals.dao.entitiesinterface.ICarDAO;
import carrentals.entities.Car;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CarsCommand implements ICommand {
    private static Logger logger = Logger.getLogger(CarsCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        /**
         * This method use Database Access Object to get list cars from database
         */
        DAOFactory factory = DAOFactory.getDAOFactory();
        ICarDAO carDAO = factory.getCarDAO();

        ArrayList<Car> listCars = carDAO.getListCarSortedBy("price");
        Car[] cars = new Car[listCars.size()];
        cars = listCars.toArray(cars);
        request.setAttribute("cars", cars);

        logger.info("Redirection to the list cars page");

        String page = PagePath.CARS_PAGE_PATH;
        return page;
    }

}
