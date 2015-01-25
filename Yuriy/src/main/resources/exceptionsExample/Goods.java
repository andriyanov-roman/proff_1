package exceptionsExample;

public class Goods {
    String name;
    int amount;
    long barcode;
    String type;

    public String toString() {
        return name + ": " + amount + ": " + barcode + ": " + type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getBarcode() {

        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public int getAmount() {

        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
