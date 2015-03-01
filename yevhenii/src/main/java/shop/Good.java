package shop;

/**
 * Created by eugene on 01.02.15.
 */
public class Good {
    private String name;
    private int quantity;
    private long code;
    private String type;

    public Good(String string, int anInt, int anInt1, String string1) {
        this.name = string;
        this.quantity = anInt;
        this.code = anInt1;
        this.type = string;
    }

    public Good() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return code + ":" + name + ":" + quantity +":" + type;
    }
}
