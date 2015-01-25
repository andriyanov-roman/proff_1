package carsPlant;

public class Car {

    private Color color;
    private Engine engine;
    private Body body;

    public String toString() {

        return "" + color + ":" + color.getPrice() + ":" +  engine + ":" + engine.getPrice() + ":" + body + ":" + engine.getPrice() ;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }


    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


}
