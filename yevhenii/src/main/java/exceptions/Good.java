package exceptions;

/**
 * Created by eugene on 24.01.15.
 */
public class Good {
    private String name;
    private int quantity;
    private long code;
    private String type;

    public Good(String name, int quantity, long code, String type) {
        this.name = name;
        this.quantity = quantity;
        this.code = code;
        this.type = type;
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
        return name + "|" + quantity +"|" + code + "|" + type;
    }
}
