package test.tag;


        import shop.dao.GoodDAOimpl;

        import javax.servlet.jsp.*;
        import javax.servlet.jsp.tagext.*;

public class MyTag extends TagSupport
{
   GoodDAOimpl goodsDAO=new GoodDAOimpl();
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
