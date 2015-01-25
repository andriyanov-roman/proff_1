package Figures;
public class Tringle extends Figure {

    private double length;
    private double hight;
    public  Tringle(double length, double hight, String name){
        super(name);
        this.length = length;
        this.hight = hight;
        Figure t1 = new Tringle(1.5,2, "Треугольник");
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

}
