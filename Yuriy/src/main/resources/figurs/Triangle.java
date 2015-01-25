package figurs;


import java.math.BigDecimal;

public class Triangle extends Figura {
    private double side;
    private double hight;

    public Triangle(double side, double hight, String name) {
        super(name);
        this.side = side;
        this.hight = hight;
    }


    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }


    public double getHight() {
        return hight;
    }
    public void setHight(double hight) {
        this.hight = hight;
    }


    public double getSquare() {
        return (side * hight) / 2;
    }

    public double getPerimeter(){
        return side * 3;
    }



}
