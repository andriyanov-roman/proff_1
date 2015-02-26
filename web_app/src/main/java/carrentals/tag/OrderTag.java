package carrentals.tag;

import carrentals.configuration.LocaleConfig;
import carrentals.entities.Car;
import carrentals.entities.Client;
import carrentals.entities.Place;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class OrderTag extends TagSupport {
    private Place[] value;
    private Place vpget;
    private Client vclient;
    private Car vcar;

    public void setValue(Place[] value) {
        this.value = value;
    }

    public void setVpget(Place vpget) {
        this.vpget = vpget;
    }

    public void setVclient(Client vclient) {
        this.vclient = vclient;
    }

    public void setVcar(Car vcar) {
        this.vcar = vcar;
    }

    public int doStartTag() throws JspException {
        String placeGet = LocaleConfig.ORDER_PLACE_GET;
        String placeReturn = LocaleConfig.ORDER_PLACE_RETURN;
        String dateGet = LocaleConfig.ORDER_DATE_GET;
        String dateReturn = LocaleConfig.ORDER_DATE_RETURN;
        String makeorder = LocaleConfig.ORDER_MAKE;
        String birthday = LocaleConfig.CLIENT_BIRTHDAY;
        String passportseries = LocaleConfig.CLIENT_PASSPORTSERIES;
        String passportnumber = LocaleConfig.CLIENT_PASSPORTNUMBER;
        String phonenumber = LocaleConfig.CLIENT_PHONENUMBER;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());

        StringBuilder stringFormat = new StringBuilder();
        Formatter formatter = new Formatter(stringFormat);
        formatter.format("<table><tr><td><form name=\"order\" method=\"POST\" action=\"carrentals\">");
        formatter.format("<input type=\"hidden\" name=\"command\" value=\"makeorder\" />");
        formatter.format("<input type=\"hidden\" name=\"idclient\" value=\"%s\" />", vclient.getIdClient());
        formatter.format("<input type=\"hidden\" name=\"idcar\" value=\"%s\" />", vcar.getIdCar());
        formatter.format(placeGet + "</td><td><select name=\"idplaceget\">");
        formatter.format("<option value=\"%d\">%s,%s</option>", vpget.getIdPlace(), vpget.getCity(), vpget.getDescriptionPlace());
        formatter.format("</select></td></tr><tr><td>");
        formatter.format(placeReturn + "</td><td><select name=\"idplacereturn\">");
        for (Place place : value) {
            formatter.format("<option value=\"%d\">%s,%s</option>", place.getIdPlace(), place.getCity(), place.getDescriptionPlace());
        }
        formatter.format("</select></td></tr><tr><td>");
        formatter.format(dateGet + "</td><td><input tpye=\"text\" name=\"dateget\" value=\"%s\"/></td></tr><tr><td>", date);
        formatter.format(dateReturn + "</td><td><input tpye=\"text\" name=\"datereturn\" value=\"%s\"/></td></tr>", date);
        if (vclient.getIdClient() == null) {
            formatter.format("<tr><td>" + birthday + "</td><td><input type=\"text\" name=\"birthday\" value=\"%s\"></td></tr>", date);
            formatter.format("<tr><td>" + passportseries + "</td><td><input type=\"text\" name=\"passportseries\" value=\"\"></td></tr>");
            formatter.format("<tr><td>" + passportnumber + "</td><td><input type=\"text\" name=\"passportnumber\" value=\"\"></td></tr>");
            formatter.format("<tr><td>" + phonenumber + "</td><td><input type=\"text\" name=\"phonenumber\" value=\"\"></td></tr>");
        }
        formatter.format("<tr><td><input type=\"submit\" value=\"%s\"></td><td></td></tr>", makeorder);
        formatter.format("</form></table>");

        try {
            pageContext.getOut().write(stringFormat.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

}
