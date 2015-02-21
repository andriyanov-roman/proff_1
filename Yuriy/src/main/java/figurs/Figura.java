package figurs;

public class Figura {

    public String name;
    public double perimeter;

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public String toString() {
        return "" + name + ":" + perimeter;
    }

    public Figura(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public double getSquare() {
        return 0.0;
    }
    public double getPerimeter(){
        return perimeter;
    }

}
