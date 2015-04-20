package shopservlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shop.entity.Good;
import shop.control.Validator;
import spring.config.AppConfig;
import spring.config.HibernateConfig;
import spring.dao.GoodsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artem on 28.02.15.
 */
public class GoodAddServlet extends HttpServlet {
    AnnotationConfigApplicationContext ctx =
            new AnnotationConfigApplicationContext(HibernateConfig.class,AppConfig.class);
    Validator validator =(Validator) ctx.getBean("getValidator");
    GoodsDAO goodsDAO = (GoodsDAO) ctx.getBean("getGoodsDao");
    Good good =(Good) ctx.getBean("getGood");

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nameOfGood");
        String type = request.getParameter("typeOfGood");
        String number = request.getParameter("numberOfGood");
        String barcode = request.getParameter("barcodeOfGood");
        if ((validator.getName(name) && validator.gerBarCode(barcode) && validator.getType(type) && validator.getNumber(number)) == true) {
            good.setType(type);
            good.setName(name);
            good.setBarcode(Long.parseLong(barcode));
            good.setNumber(Integer.parseInt(number));
            goodsDAO.executeGood(good);

            RequestDispatcher view = request.getRequestDispatcher("goodCorrect.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("goodNotValid.jsp");
            view.forward(request, response);
        }
    }
}
