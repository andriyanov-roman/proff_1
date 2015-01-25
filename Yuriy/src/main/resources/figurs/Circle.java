package figurs;

import java.math.BigDecimal;

public class Circle extends Figura {

    private int radius;

    public Circle(String name, int radius) {
        super(name);
        this.radius = radius;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    public double getSquare() {
        return (radius * radius) * Math.PI;
    }


    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }


}
