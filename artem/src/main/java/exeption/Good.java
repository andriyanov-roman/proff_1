package exeption;

import java.math.BigDecimal;

/**
 * Created by artem on 24.01.15.
 */
public class Good {
    String name;
    BigDecimal number;
    BigDecimal barcode;
    String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getBarcode() {
        return barcode;
    }

    public void setBarcode(BigDecimal barcode) {
        this.barcode = barcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String toString() {
        return getName()+":"+getNumber()+":"+getBarcode()+":"+getType()+":";
    }
}
