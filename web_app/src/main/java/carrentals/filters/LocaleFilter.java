package carrentals.filters;

import carrentals.configuration.LocaleConfig;
import carrentals.dao.entitiesdao.CarDAO;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

public class LocaleFilter implements Filter {
    private static Logger logger = Logger.getLogger(CarDAO.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Locale filter set us default - US");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        Locale locale = LocaleConfig.getCurrentLocale();
        HttpSession session = servletRequest.getSession(true);
        Config.set(session, Config.FMT_LOCALE, locale);

        if (chain != null) {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

}
