package carrentals.controller.commands;

import carrentals.controller.PagePath;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexCommand implements ICommand {
    private static Logger logger = Logger.getLogger(IndexCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        logger.info("Redirection to the index page");
        String page = PagePath.INDEX_PAGE_PATH;
        return page;
    }

}
