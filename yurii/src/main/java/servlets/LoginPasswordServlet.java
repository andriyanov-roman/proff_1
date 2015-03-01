package servlets;

import shop.User;
import shop.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class LoginPasswordServlet extends HttpServlet {
    Validator validator;

    public void init() throws ServletException {
        validator = new Validator();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User u = new User();
        u.setLogin(login);
        u.setPasword(password);
        try {
            if (validator.isLoginAndPasswordCorrect(u)) {
                RequestDispatcher view = request.getRequestDispatcher("");
                view.forward(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("");
                view.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
