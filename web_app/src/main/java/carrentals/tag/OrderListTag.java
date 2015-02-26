package carrentals.tag;

import carrentals.configuration.LocaleConfig;
import carrentals.entities.Order;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Formatter;


public class OrderListTag extends TagSupport {
    private Order value;

    public void setValue(Order value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {
        String order = LocaleConfig.ORDER;
        String confirm = LocaleConfig.ORDER_CONFIRM;
        String reject = LocaleConfig.ORDER_REJECT;
        String executed = LocaleConfig.ORDER_EXECUTED;
        String notexecuted = LocaleConfig.ORDER_NOTEXECUTED;
        String description = LocaleConfig.ORDER_DESCRIPTION;
        String damage = LocaleConfig.ORDER_DAMAGE;
        String save = LocaleConfig.ORDER_SAVE;
        String state = LocaleConfig.ORDER_STATE;

        StringBuilder stringFormat = new StringBuilder();
        Formatter formatter = new Formatter(stringFormat);
        formatter.format("<table width=\"%d\"><tr><td><form name=\"orderlist\" method=\"POST\" action=\"carrentals\">", 680);
        formatter.format("<input type=\"hidden\" name=\"command\" value=\"updateorder\" />");
        formatter.format("<input type=\"hidden\" name=\"idorder\" value=\"%s\" />", value.getIdOrder());
        formatter.format(order + "� %s</td><td>", value.getIdOrder());
        formatter.format("<select name=\"stateorder\">");
        formatter.format("<option value=\"true\">%s</option>", confirm);
        formatter.format("<option value=\"false\">%s</option>", reject);
        formatter.format("</select></td>");
        formatter.format("<td>%s: %s</td><td>", state, value.isStateOrder());
        formatter.format("%s<input type=\"text\" name=\"description\" value=\" %s\"></td></tr>", description, (value.getDescription() == null) ? "" : value.getDescription());
        formatter.format("<tr><td><input type=\"submit\" value=\"%s\"></td><td><select name=\"orderexecuted\">", save);
        formatter.format("<option value=\"true\">%s</option>", executed);
        formatter.format("<option value=\"false\">%s</option>", notexecuted);
        formatter.format("</select></td>");
        formatter.format("<td>%s: %s</td><td>", executed, value.isOrderExecuted());
        formatter.format("%s<input type=\"text\" name=\"descriptiondamage\" value=\" %s\"></td></tr>", damage, (value.getDescriptionDamage() == null) ? "" : value.getDescriptionDamage());
        formatter.format("</form></table>");

        try {
            pageContext.getOut().write(stringFormat.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

}
