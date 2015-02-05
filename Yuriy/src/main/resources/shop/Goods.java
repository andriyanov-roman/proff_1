package shop;

public class Goods {
    String name;
    int amount;
    long barcode;
    String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (amount != goods.amount) return false;
        if (barcode != goods.barcode) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (type != null ? !type.equals(goods.type) : goods.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + amount;
        result = 31 * result + (int) (barcode ^ (barcode >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return
                "name = '" + name + '\'' +
                ", amount = " + amount +
                ", barcode = " + barcode +
                ", type = '" + type + '\'';
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
