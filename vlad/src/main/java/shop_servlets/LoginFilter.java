package shop_servlets;

import shop.users.User;
import shop.validation.UserValidator;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;


public class LoginFilter implements javax.servlet.Filter {
    UserValidator validator;

    @Override

    public void init(FilterConfig filterConfig) throws ServletException {
        validator = new UserValidator();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        if (validator.userExists(user)) {
            RequestDispatcher view = request.getRequestDispatcher("menu.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("wrongValidation.jsp");
            view.forward(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
