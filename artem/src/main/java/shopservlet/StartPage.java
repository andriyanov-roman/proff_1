package shopservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artem on 14.03.15.
 */
public class StartPage extends HttpServlet {
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher view = request.getRequestDispatcher("startPage.jsp");
            view.forward(request, response);
        }
}
