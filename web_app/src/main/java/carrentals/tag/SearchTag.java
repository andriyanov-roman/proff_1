package carrentals.tag;

import carrentals.configuration.LocaleConfig;
import carrentals.entities.Place;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class SearchTag extends TagSupport {
    private Place[] value;

    public void setValue(Place[] value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {

        String placeGet = LocaleConfig.ORDER_PLACE_GET;
        String placeReturn = LocaleConfig.ORDER_PLACE_RETURN;
        String dateGet = LocaleConfig.ORDER_DATE_GET;
        String dateReturn = LocaleConfig.ORDER_DATE_RETURN;
        String search = LocaleConfig.MENU_SEARCH;
        String price = LocaleConfig.CAR_PRICE_NOT_MORE;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());

        StringBuilder stringFormat = new StringBuilder();
        Formatter formatter = new Formatter(stringFormat);
        formatter.format("<table><tr><td><form name=\"search\" method=\"POST\" action=\"carrentals\">");
        formatter.format("<input type=\"hidden\" name=\"command\" value=\"searchcars\" />");
        formatter.format(placeGet + "</td><td><select name=\"idplaceget\">");
        for (Place place : value) {
            formatter.format("<option value=\"%d\">%s,%s</option>", place.getIdPlace(), place.getCity(), place.getDescriptionPlace());
        }
        formatter.format("</select></td></tr><tr><td>");
        formatter.format(placeReturn + "</td><td><select name=\"idplacereturn\">");
        for (Place place : value) {
            formatter.format("<option value=\"%d\">%s,%s</option>", place.getIdPlace(), place.getCity(), place.getDescriptionPlace());
        }
        formatter.format("</select></td></tr><tr><td>");
        formatter.format(dateGet + "</td><td><input tpye=\"text\" name=\"dateget\" value=\"%s\"/></td></tr><tr><td>", date);
        formatter.format(dateReturn + "</td><td><input tpye=\"text\" name=\"datereturn\" value=\"%s\"/></td></tr><tr><td>", date);
        formatter.format(price + "</td><td><input tpye=\"text\" name=\"pricenotmore\" value=\"%d\"/></td></tr>", 100);
        formatter.format("<tr><td><input type=\"submit\" value=\"%s\"></td><td></td></tr>", search);
        formatter.format("</form></table>");

        try {
            pageContext.getOut().write(stringFormat.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

}
