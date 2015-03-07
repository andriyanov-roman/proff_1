package shopservlet;

import shop.ControlUser;
import shop.dao.GoodsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by artem on 28.02.15.
 */
public class LoginServlet extends HttpServlet {

    ControlUser controlUser=new ControlUser();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        boolean check=false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
           check=controlUser.checkUser(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        if (check == true) {
            RequestDispatcher view = request.getRequestDispatcher("mainmenu.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("notValidUser.jsp");
            view.forward(request, response);
        }
    }

}



