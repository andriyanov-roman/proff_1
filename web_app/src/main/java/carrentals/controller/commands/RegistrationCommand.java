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

public class RegistrationCommand implements ICommand {
    private static Logger logger = Logger.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String page;
        /**
         * This method use Database Access Object to create new use.
         */
        DAOFactory factory = DAOFactory.getDAOFactory();
        IUserDAO userDAO = factory.getUserDAO();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String middlename = request.getParameter("middlename");
        String email = request.getParameter("email");
        User user = userDAO.checkUserLogin(login, password);

        LocaleConfig langConfig = LocaleConfig.getInstance();
        String messageError = langConfig.getText(LocaleConfig.MESSAGE_ERROR_USER);
        String messageHello = langConfig.getText(LocaleConfig.MESSAGE_HELLO_USER);
        if ((user.getRole()).equals("guest")) {
            user = new User("user", login, password, email, name, surname, middlename);
            userDAO.createUser(user);
            logger.info("User was create");
            request.setAttribute("message", messageHello);
        } else {
            logger.info("User with this login already exists");
            request.setAttribute("message", messageError);
        }

        logger.info("Redirection to the message page");

        page = PagePath.MESSAGE_PAGE_PATH;
        return page;
    }

}
