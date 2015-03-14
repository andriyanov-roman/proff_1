package shopservlet;

import shop.ControlUser;
import shop.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by artem on 14.03.15.
 */
public class RegistrationPage {
    ControlUser controlUser=new ControlUser();
    User user=new User();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        boolean check=false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            if(controlUser.checkUser(username, password)==true){
                RequestDispatcher view = request.getRequestDispatcher("notValidUser.jsp");
                view.forward(request, response);
            }
            else{
                user.setLogin(username);
                user.setPassword(password);
                controlUser.registationUser(user);
                RequestDispatcher view = request.getRequestDispatcher("mainmenu.jsp");
                view.forward(request, response);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
