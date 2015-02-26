package carrentals.controller.commands;

import carrentals.controller.PagePath;
import carrentals.entities.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserOutCommand implements ICommand {
    private static Logger logger = Logger.getLogger(UserOutCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("role", new User().getRole());
        request.getSession().setAttribute("ID", new User().getId());

        logger.info("User is logout");
        logger.info("Redirection to the index page");

        String page = PagePath.INDEX_PAGE_PATH;
        return page;
    }

}
