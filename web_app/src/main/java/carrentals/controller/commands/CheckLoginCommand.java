package carrentals.controller.commands;

import carrentals.configuration.LocaleConfig;
import carrentals.controller.PagePath;
import carrentals.dao.DAOFactory;
import carrentals.dao.entitiesinterface.IUserDAO;
import carrentals.entities.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CheckLoginCommand implements ICommand {
    private static Logger logger = Logger.getLogger(CheckLoginCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        logger.info("Check user login and password");
        String page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        /**
         * This method use Database Access Object to get user
         * from database with entered parameters
         */
        DAOFactory factory = DAOFactory.getDAOFactory();
        IUserDAO userDAO = factory.getUserDAO();
        User user = userDAO.checkUserLogin(login, password);
        /**
         * After received user, enters "role" and "ID" in the session
         */
        request.getSession().setAttribute("role", user.getRole());
        request.getSession().setAttribute("ID", user.getId());

        if ((user.getRole()).equals("guest")) {
            LocaleConfig langConfig = LocaleConfig.getInstance();
            String message = langConfig.getText(LocaleConfig.MESSAGE_ERROR_LOGIN);
            request.setAttribute("message", message);
            logger.info("Wrong user login and password");
            page = PagePath.MESSAGE_PAGE_PATH;
        } else {
            logger.info("Correct user login");
            page = PagePath.INDEX_PAGE_PATH;
        }
        return page;
    }
}
