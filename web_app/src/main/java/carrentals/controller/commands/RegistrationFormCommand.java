package carrentals.controller.commands;

import carrentals.controller.PagePath;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationFormCommand implements ICommand {
    private static Logger logger = Logger.getLogger(RegistrationFormCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        logger.info("Redirection to the registration page");

        String page = PagePath.REGISTRATION_PAGE_PATH;
        return page;
    }

}
