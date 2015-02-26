package carrentals.controller.commands;

import carrentals.controller.PagePath;
import carrentals.dao.DAOFactory;
import carrentals.dao.entitiesinterface.IClientDAO;
import carrentals.dao.entitiesinterface.IUserDAO;
import carrentals.entities.Client;
import carrentals.entities.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileCommand implements ICommand {
    private static Logger logger = Logger.getLogger(ProfileCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        /**
         * This method use Database Access Object to get user and client
         * from database with parameters from session
         */
        DAOFactory factory = DAOFactory.getDAOFactory();
        IUserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getUser((Integer) request.getSession().getAttribute("ID"));
        request.setAttribute("user", user);
        IClientDAO clientDAO = factory.getClientDAO();
        Client client = clientDAO.getClient((Integer) request.getSession().getAttribute("ID"));
        request.setAttribute("client", client);

        logger.info("Redirection to the profile page");

        String page = PagePath.PROFILE_PAGE_PATH;
        return page;
    }

}
