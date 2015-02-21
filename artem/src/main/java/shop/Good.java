package shop;

/**
 * Created by artem on 24.01.15.
 */
public class Good {
    String name;
    int number;
    long barcode;

    String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String toString() {
        return getName()+":"+getNumber()+":"+getBarcode()+":"+getType();
    }
}
