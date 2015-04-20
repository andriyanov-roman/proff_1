package test.bean;

import hiber.HibGoodsDAO;
import shop.entity.Good;
import shop.control.Validator;

import java.io.Serializable;

/**
 * Created by artem on 15.03.15.
 */
public class GoodsBean implements Serializable {
    private String number;
    private String barcode;
    private String name;
    private String type;
    private String page;



    public void setPage(String page) {
        this.page = page;
    }

    Validator validator = new Validator();
    Good good = new Good();
    HibGoodsDAO hibGoodsDAO = new HibGoodsDAO();

    public GoodsBean() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPage() {
        if (name != null && type != null && barcode != null && number != null) {
            good.setType(type);
            good.setName(name);
            good.setBarcode(Long.parseLong(barcode));
            good.setNumber(Integer.parseInt(number));
            hibGoodsDAO.executeGood(good);
            page="goodCorrect.jsp";
            return page;
        } else {
            page="mainmenu.jsp";
            return page;
        }
    }

    public String saveGood() {
        if (type != null && name != null && barcode != null && number != null) {
            good.setType(type);
            good.setName(name);
            good.setBarcode(Long.parseLong(barcode));
            good.setNumber(Integer.parseInt(number));
            hibGoodsDAO.executeGood(good);
            page="goodCorrect.jsp";
            return page;
        } else {
            page="mainmenu.jsp";
            return page;
        }
    }
}
