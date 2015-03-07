package servlets;
import shop.GoodDAOImpl;

import javax.servlet.http.HttpServlet;


public class SeeAllGoodsServlet extends HttpServlet {
    GoodDAOImpl goodDAO;

    public void init() {
        goodDAO = new GoodDAOImpl();
    }

}
