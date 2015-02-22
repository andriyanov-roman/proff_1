package servelets;

import shop.Good;
import shop.dao.GoodsDAO;
import shop.dbaccess.ConnectionToDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by artem on 22.02.15.
 */
public class Hello extends HttpServlet {
    ArrayList<Good> goods;

    public void init() throws ServletException {
        try {
            goods = new GoodsDAO().readFromDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + goods.toString() + "</h1>");
    }

    public void destroy() {
        // do nothing.
    }
}
