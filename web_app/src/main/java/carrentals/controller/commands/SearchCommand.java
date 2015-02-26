package carrentals.controller.commands;

import carrentals.controller.PagePath;
import carrentals.dao.DAOFactory;
import carrentals.dao.entitiesinterface.IPlaceDAO;
import carrentals.entities.Place;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SearchCommand implements ICommand {
    private static Logger logger = Logger.getLogger(SearchCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        /**
         * This method use Database Access Object
         * to get places from database.
         */
        DAOFactory factory = DAOFactory.getDAOFactory();
        IPlaceDAO placeDAO = factory.getPlaceDAO();
        ArrayList<Place> listPlaces = placeDAO.getListPlaceSortedByCity();
        Place[] places = new Place[listPlaces.size()];
        places = listPlaces.toArray(places);
        request.setAttribute("places", places);

        logger.info("Redirection to the search page");

        String page = PagePath.SEARCH_PAGE_PATH;
        return page;
    }

}
