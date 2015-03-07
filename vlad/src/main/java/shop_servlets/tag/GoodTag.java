package shop_servlets.tag;

import shop.db_access.GoodDAO;
import shop.goods.Good;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Formatter;
import java.util.Set;

public class GoodTag extends TagSupport {
    public int doEndTag() throws JspException {
        Set<Good> goods = new GoodDAO().selectAll();
        Formatter formatter = new Formatter();
        try {
            for (Good g : goods){
                formatter.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>"
                        , g.getName(), g.getQuantity(), g.getBarcode(), g.getType());}
            pageContext.getOut().print(formatter);
        } catch (Exception e) {
            throw new JspException(e.toString());
        }
        return EVAL_PAGE;
    }
}