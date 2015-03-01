package servlets;

import shop.User;
import shop.UserDAOImpl;
import shop.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterNewUserServlet extends HttpServlet {
    UserDAOImpl userDAO;
    Validator valid;

    public void init() {
        userDAO = new UserDAOImpl();
        valid = new Validator();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User();
        user.setLogin(login);
        user.setPasword(password);
        try {
            if (valid.isUserAllrExist(user)) {
                RequestDispatcher view = request.getRequestDispatcher("startPage.jsp");
                view.forward(request, response);
            } else {
                userDAO.executeUpdate(user);
                RequestDispatcher view = request.getRequestDispatcher("userMenu.jsp");
                view.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
