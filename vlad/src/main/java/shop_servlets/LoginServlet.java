package shop_servlets;

import shop.users.User;
import shop.validation.UserValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    UserValidator validator;

    public void init() {
        validator = new UserValidator();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        if (validator.userExists(user)) {
            RequestDispatcher view = request.getRequestDispatcher("menu.jsp");
            HttpSession session = request.getSession(true);

            session.setAttribute("name", username);
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("wrongValidation.jsp");
            view.forward(request, response);
        }

    }
}