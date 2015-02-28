package shop_servlets;

import shop.db_access.GoodDAO;
import shop.goods.Good;
import shop.validation.UserValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class LoginServlet extends HttpServlet {
    UserValidator validator;

    public void init() {
        validator = new UserValidator();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        if (validator.isUserCorrect(username, password)) {
            RequestDispatcher view = request.getRequestDispatcher("menu.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("wrongValidation.jsp");
            view.forward(request, response);
        }

    }
}
