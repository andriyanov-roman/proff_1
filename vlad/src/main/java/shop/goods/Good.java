package shop.goods;

public class Good {
    private String name;
    private int quantity;
    private long barcode;
    private String type;

    public Good() {

    }

    public Good(String name, int quantity, long barcode, String type) {
        this.barcode = barcode;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }
//one constructor for creating goods using getters and setters, another for restoring goods to Set in getAllGoods()

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
        return name +
                ":" + quantity +
                ":" + barcode +
                ":" + type + "=";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (barcode != good.barcode) return false;
        if (quantity != good.quantity) return false;
        if (name != null ? !name.equals(good.name) : good.name != null) return false;
        if (type != null ? !type.equals(good.type) : good.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + quantity;
        result = 31 * result + (int) (barcode ^ (barcode >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
