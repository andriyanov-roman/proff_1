package shop_servlets;

import shop.users.User;
import shop.users.UserUtility;
import shop.validation.UserValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    UserValidator validator;
    UserUtility userUtility;

    public void init() {
        userUtility = new UserUtility();
        validator = new UserValidator();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);

        if (validator.userExists(user)) {
            RequestDispatcher view = request.getRequestDispatcher("wrongUser.jsp");
            view.forward(request, response);
        } else {
            userUtility.addUser(user);
            RequestDispatcher view = request.getRequestDispatcher("login.jsp");
            view.forward(request, response);
        }

    }
}
