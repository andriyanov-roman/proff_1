package shopservlet;

import hiber.HibGoodsDAO;
import shop.Good;
import shop.dao.GoodsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artem on 28.02.15.
 */
public class ShowList extends HttpServlet {
    List<Good> goods;

    public void init() throws ServletException {
            goods = new HibGoodsDAO().readFromBD();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher view = request.getRequestDispatcher("goodShowAll.jsp");

        PrintWriter out = response.getWriter();
        out.println("<br>" + goods.toString()+ "</br>");
    }


}


