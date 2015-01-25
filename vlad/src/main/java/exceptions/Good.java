package exceptions;

/**
 * Created by root on 25.01.15.
 */
public class Good {
    private String name;
    private int quantity;
    private long barcode;
    private String type;

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "Good " +
                "name: " + name +
                " quantity: " + quantity +
                " barcode: " + barcode +
                " type: " + type;
    }
}
