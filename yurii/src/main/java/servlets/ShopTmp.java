package servlets;


import shop.Good;
import shop.GoodDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;

public class ShopTmp extends HttpServlet {
    Set<Good> goods;

    public void init() throws ServletException {
        // Do required initialization
        try {
            goods = new GoodDAOImpl().selectGood();
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
