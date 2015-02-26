package carrentals.controller.commands;

import carrentals.configuration.LocaleConfig;
import carrentals.controller.PagePath;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

public class LocaleCommand implements ICommand {
    private static Logger logger = Logger.getLogger(LocaleCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        logger.info("Change user locale");
        Locale locale = new Locale("en", "US");
        String language = request.getParameter("lang");
        int number = Integer.parseInt(language);
        switch (number) {
            case 1: {
                locale = new Locale("ru", "RU");
                logger.info("Locale - RU");
                break;
            }
            case 2: {
                locale = new Locale("en", "US");
                logger.info("Locale - US");
                break;
            }
        }
        HttpSession session = request.getSession(true);
        Config.set(session, Config.FMT_LOCALE, locale);
        LocaleConfig.changeLocale(locale);

        LocaleConfig langConfig = LocaleConfig.getInstance();
        String message = langConfig.getText(LocaleConfig.MESSAGE_LOCALE_CHANGE);
        request.setAttribute("message", message);

        logger.info("Redirection to the message page");

        String page = PagePath.MESSAGE_PAGE_PATH;
        return page;
    }

}
