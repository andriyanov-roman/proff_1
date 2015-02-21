package figurs;


import java.math.BigDecimal;

public class Square extends Figura {

    public Square(String name, int side) {
        super(name);
        this.side = side;
    }

    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }




    public double getSquare() {
        return side * side;
    }



    public double getPerimeter() {
        return side * 4;
    }
}
