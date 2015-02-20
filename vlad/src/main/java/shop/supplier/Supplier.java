package shop.supplier;

/**
 * Created by root on 20.02.15.
 */
public class Supplier {
    private String name;
    private String goodType;
    private int goodID;

    public Supplier(String name, String goodType, int goodID) {
        this.goodID = goodID;
        this.goodType = goodType;
        this.name = name;
    }

    public Supplier() {
    }

    public int getGoodID() {
        return goodID;
    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        if (goodID != supplier.goodID) return false;
        if (goodType != null ? !goodType.equals(supplier.goodType) : supplier.goodType != null) return false;
        if (name != null ? !name.equals(supplier.name) : supplier.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (goodType != null ? goodType.hashCode() : 0);
        result = 31 * result + goodID;
        return result;
    }
}
