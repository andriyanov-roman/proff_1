package carsPlant;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Plant {

    private String path = "c:\\report.txt";

    public ArrayList<String[]> getStrings(String path, String regexp) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>();

        File f = new File(path);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            lines.add(s.next());
        }

        ArrayList<String[]> splitingStrings = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            splitingStrings.add(lines.get(i).split(regexp));
        }
        return splitingStrings;
    }


    public ArrayList<Car> createCarsByColor() throws FileNotFoundException {
        ArrayList<String[]> colorsState = getStrings("c:\\color.txt", ":");
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < colorsState.size(); i++) {

            Color color = new Color(colorsState.get(i)[0]);
            color.setPrice(new BigDecimal(colorsState.get(i)[1]));

            Body body = new Body(getStrings("c:\\body.txt", ":").get(i)[0]);
            body.setPrice(new BigDecimal(getStrings("c:\\body.txt", ":").get(i)[1]));

            Engine engine = new Engine(getStrings("c:\\engine.txt", ":").get(i)[0]);
            engine.setPrice(new BigDecimal(getStrings("c:\\engine.txt", ":").get(i)[1]));

            Car car = new Car();
            car.setColor(color);
            car.setEngine(engine);
            car.setBody(body);
            cars.add(car);
        }
        writeToFile(cars, path);
        return cars;
    }

    public ArrayList<Car> createCarsByBody() throws FileNotFoundException {
        ArrayList<String[]> bodyType = getStrings("c:\\body.txt", ":");
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < bodyType.size(); i++) {
            Body body = new Body(bodyType.get(i)[0]);
            body.setPrice(new BigDecimal(bodyType.get(i)[1]));

            Color color = new Color(getStrings("c:\\color.txt", ":").get(i)[0]);
            color.setPrice(new BigDecimal(getStrings("c:\\color.txt", ":").get(i)[1]));

            Engine engine = new Engine(getStrings("c:\\engine.txt", ":").get(i)[0]);
            engine.setPrice(new BigDecimal(getStrings("c:\\engine.txt", ":").get(i)[1]));

            Car car = new Car();
            car.setEngine(engine);
            car.setColor(color);
            car.setBody(body);
            cars.add(car);
        }
        writeToFile(cars, path);
        return cars;
    }

    public ArrayList<Car> createCarByEngine() throws FileNotFoundException {

        ArrayList<String[]> engineType = getStrings("c:\\engine.txt", ":");
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < engineType.size(); i++) {
            Engine engine = new Engine(engineType.get(i)[0]);
            engine.setPrice(new BigDecimal(engineType.get(i)[1]));

            Body body = new Body(getStrings("c:\\body.txt", ":").get(i)[0]);
            body.setPrice(new BigDecimal(getStrings("c:\\body.txt", ":").get(i)[1]));

            Color color = new Color(getStrings("c:\\color.txt", ":").get(i)[0]);
            color.setPrice(new BigDecimal(getStrings("c:\\color.txt", ":").get(i)[1]));

            Car car = new Car();
            car.setEngine(engine);
            car.setBody(body);
            car.setColor(color);
            cars.add(car);

        }
        writeToFile(cars, path);
        return cars;
    }


    public void writeToFile(ArrayList<Car> cars, String path) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            for (int i = 0; i < cars.size(); i++) {
                out.println(cars.get(i).toString());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
