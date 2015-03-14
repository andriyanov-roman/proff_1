package shop_servlets;

import shop.db_access.GoodDAO;
import shop.goods.Good;
import shop.goods.GoodUtility;
import shop.validation.GoodsValidator;
import shop.validation.UserValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodEnterServlet extends HttpServlet {
    GoodsValidator goodsValidator;
    GoodUtility goodUtility;
    GoodDAO goodDAO = new GoodDAO();

    public void init() {
        goodsValidator = new GoodsValidator();
        goodUtility = new GoodUtility();
        goodDAO = new GoodDAO();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String quantity = request.getParameter("quantity");
        String barcode = request.getParameter("barcode");
        String type = request.getParameter("type");

        if (goodsValidator.isGoodNameValid(name) && goodsValidator.isGoodQuantityValid(quantity)
                && goodsValidator.isGoodBarcodeValid(barcode)
                && goodsValidator.isGoodTypeValid(type)) {
            Good good = new Good(name, Integer.parseInt(quantity), Long.parseLong(barcode), type);

            if (goodDAO.selectAll().contains(good)) {
                response.sendError(400);
            } else {
                goodUtility.addGood(good);
                RequestDispatcher view = request.getRequestDispatcher("goodCorrect.jsp");
                view.forward(request, response);
            }

        } else {
            RequestDispatcher view = request.getRequestDispatcher("goodIncorrect.jsp");
            view.forward(request, response);
        }
    }
}
