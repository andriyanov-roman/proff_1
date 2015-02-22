package carsPlant;


import java.math.BigDecimal;

public class Engine extends Options {

    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String toString() {
        return "" + type + "";
    }
}
