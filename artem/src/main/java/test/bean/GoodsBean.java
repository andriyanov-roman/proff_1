package test.bean;

import java.io.Serializable;

/**
 * Created by artem on 15.03.15.
 */
public class GoodsBean implements Serializable {
    private int number;
    private long barcode;
    private String name;
    private String type;

    public GoodsBean() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
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
}
