package Figures;
public class Square extends Figure {
    public Square (double length, String name){
        super(name);
        this.length = length;
    }
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
