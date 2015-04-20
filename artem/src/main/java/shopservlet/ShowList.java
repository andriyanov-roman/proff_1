package shopservlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shop.entity.Good;
import spring.config.AppConfig;
import spring.config.HibernateConfig;
import spring.dao.GoodsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by artem on 28.02.15.
 */
public class ShowList extends HttpServlet {
    AnnotationConfigApplicationContext ctx =
            new AnnotationConfigApplicationContext(HibernateConfig.class,AppConfig.class);
    GoodsDAO goodsDAO=(GoodsDAO) ctx.getBean("getGoodsDao");
    List<Good> goods;

    public void init() throws ServletException {
            goods = goodsDAO.findAllGoods();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher view = request.getRequestDispatcher("goodShowAll.jsp");

        PrintWriter out = response.getWriter();
        out.println("<br>" + goods.toString()+ "</br>");
    }


}


