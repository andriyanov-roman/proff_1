package shopservlet;

import shop.Good;
import shop.dao.GoodsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by artem on 28.02.15.
 */
public class ShowList extends HttpServlet {
    ArrayList<Good> goods;

    public void init() throws ServletException {
        try {
            goods = new GoodsDAO().readFromDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher view = request.getRequestDispatcher("goodShowAll.jsp");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + goods.toString() + "</h1>");
    }

}
