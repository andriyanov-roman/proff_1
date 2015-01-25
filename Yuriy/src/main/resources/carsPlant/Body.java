package carsPlant;


public class Body extends Options {

    private String type;

    public Body(String type) {
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
