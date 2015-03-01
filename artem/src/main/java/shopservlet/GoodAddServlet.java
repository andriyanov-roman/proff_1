package shopservlet;

import shop.Good;
import shop.Validator;
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
public class GoodAddServlet extends HttpServlet {
    Validator validator=new Validator();
    GoodsDAO goodsDAO=new GoodsDAO();
    Good good=new Good();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException{
        String name=request.getParameter("nameOfGood");
        String type=request.getParameter("typeOfGood");
        String number=request.getParameter("numberOfGood");
        String barcode=request.getParameter("barcodeOfGood");
        if((validator.getName(name)&&validator.gerBarCode(barcode)&&validator.getType(type)&&validator.getNumber(number))==true){
            good.setType(type);
            good.setName(name);
            good.setBarcode(Long.parseLong(barcode));
            good.setNumber(Integer.parseInt(number));
            try {
                goodsDAO.executeUpdate(good);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher view = request.getRequestDispatcher("goodCorrect.jsp");
            view.forward(request, response);
        }
        else {
            RequestDispatcher view = request.getRequestDispatcher("goodNotValid.jsp");
            view.forward(request, response);
        }
    }
}
