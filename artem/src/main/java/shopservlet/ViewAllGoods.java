package shopservlet;

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
public class ViewAllGoods extends HttpServlet {
    GoodsDAO goodsDAO=new GoodsDAO();
    public void init() {
        goodsDAO = new GoodsDAO();
    }
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("goodShowAll.jsp");
        view.forward(request, response);
    }
}
