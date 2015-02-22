package report;

import carsPlant.Body;
import carsPlant.Color;
import carsPlant.Engine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ReportCarsReverse implements IReportMaker<ReportCarsReverse.CarHelper> {
    ArrayList<CarHelper> cars = new ArrayList<>();

    @Override
    public ArrayList<CarHelper> genereteReport() {
        return null;
    }

    @Override
    public String getPath() {
        return null;
    }

    public void generateReport() throws IOException {
        CarHelper helper = new CarHelper();
        helper.getCars();
        for (int i = 0; i < cars.size(); i++) {
            for (int j = 0; j < cars.size() - 1; j++) {
                if (sumOptions(cars.get(j)).compareTo(sumOptions(cars.get(j + 1))) == 1) {
                    CarHelper tmp = cars.get(j);
                    cars.set(j, cars.get(j + 1));
                    cars.set(j + 1, tmp);
                }
            }
        }
        writeToFile(cars, "c:\\carsByCoast.txt");
    }

    private BigDecimal sumOptions(CarHelper helper) {
        BigDecimal b = new BigDecimal(0);
        b = b.add(helper.body.getPrice());
        b = b.add(helper.color.getPrice());
        b = b.add(helper.engine.getPrice());
        return b;
    }


    public class CarHelper {
        private Color color;
        private Engine engine;
        private Body body;

        private static final int COLOR = 0;
        private static final int COLOR_PRICE = 1;
        private static final int ENGINE = 2;
        private static final int ENGINE_PRICE = 3;
        private static final int BODY = 4;
        private static final int BODY_PRICE = 5;

        public void getCars() throws IOException {
            ArrayList<String[]> strings = getString("src//report.txt");

            for (int i = 0; i < strings.size(); i++) {
                CarHelper helper = new CarHelper();
                helper.color = new Color(strings.get(i)[COLOR]);
                helper.color.setPrice(new BigDecimal(strings.get(i)[COLOR_PRICE]));
                helper.engine = new Engine(strings.get(i)[ENGINE]);
                helper.engine.setPrice(new BigDecimal(strings.get(i)[ENGINE_PRICE]));
                helper.body = new Body(strings.get(i)[BODY]);
                helper.body.setPrice(new BigDecimal(strings.get(i)[BODY_PRICE]));
                cars.add(helper);
            }
        }

        public String toString() {
            return color + "" + color.getPrice() + ":" + engine + "" + engine.getPrice() + ":" + body + "" + body.getPrice();
        }
    }

    public ArrayList<String[]> getString(String path) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : Files.readAllLines(Paths.get(path))) {
            strings.add(s);
        }
        ArrayList<String[]> stringsSplit = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            stringsSplit.add(strings.get(i).split(":"));
        }
        return stringsSplit;
    }

    public void writeToFile(ArrayList<CarHelper> cars, String path) {
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
