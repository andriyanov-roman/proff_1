package test.tag;


        import shop.Good;
        import shop.dao.GoodsDAO;

        import javax.servlet.ServletException;
        import javax.servlet.jsp.*;
        import javax.servlet.jsp.tagext.*;

        import java.io.IOException;
        import java.sql.SQLException;
        import java.util.ArrayList;

public class MyTag extends TagSupport
{
   GoodsDAO goodsDAO=new GoodsDAO();
//    ArrayList <Good> goods=new ArrayList<>();
//
//    public void init() throws ServletException {
//        try {
//            goods = new GoodsDAO().readFromDB();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public int doEndTag() throws JspException {
        try {
                pageContext.getOut().print("<br>" + goodsDAO.readFromDB().toString()+ "</br>");

        } catch (Exception e) {
            throw new JspException(e.toString());
        }
        return EVAL_PAGE;
    }
}
