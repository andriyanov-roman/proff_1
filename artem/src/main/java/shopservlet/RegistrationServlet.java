package shopservlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shop.control.ControlUser;
import shop.entity.User;
import shop.control.Validator;
import spring.config.AppConfig;
import spring.config.HibernateConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by artem on 14.03.15.
 */
public class RegistrationServlet extends HttpServlet {
    AnnotationConfigApplicationContext ctx =
            new AnnotationConfigApplicationContext(HibernateConfig.class,AppConfig.class);
    ControlUser controlUser=(ControlUser) ctx.getBean("getControlUser");
    User user=(User) ctx.getBean("getUser");
    Validator validator = (Validator) ctx.getBean("getValidator");

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            if(((controlUser.checkUser(username, password)==false)||((validator.getName(username)&&validator.getName(password))==true))==true){
                user.setLogin(username);
                user.setPassword(password);
                controlUser.registationUser(user);
                RequestDispatcher view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
            }
            else{
                RequestDispatcher view = request.getRequestDispatcher("errorregistration.jsp");
                view.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
