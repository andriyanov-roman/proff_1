package servlets;

import shop.Good;
import shop.GoodDAOImpl;
import shop.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Таня on 01.03.2015.
 */
public class AddNewGoodServlet extends HttpServlet {
    GoodDAOImpl goodDAO;
    Validator validator;

    public void init() {
        goodDAO = new GoodDAOImpl();
        validator = new Validator();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String  amount = request.getParameter("quantity");
        String barcode = request.getParameter("barcode");
        String type = request.getParameter("type");
        Good good = new Good();
        good.setName(name);
        good.setAmount(Integer.parseInt(amount));
        good.setBarcode(Long.parseLong(barcode));
        good.setType(type);
        try {
            if (validator.isGoodAllrExist(good)){
                RequestDispatcher view = request.getRequestDispatcher("addNewGood.jsp");
                view.forward(request, response);
            }else {
                goodDAO.executeUpdate(good);
                RequestDispatcher view = request.getRequestDispatcher("userMenu.jsp");
                view.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




