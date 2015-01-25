package carsPlant;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // System.out.println(getDataFromFile().get(1)[0]);
        Plant plant = new Plant();
        plant.createCarsByColor();
//      plant.createCarByEngine();
//      plant.createCarsByBody();


    }


    static ArrayList<String[]> getDataFromFile() throws FileNotFoundException {              // Trening class !!!!!!!!!!
        String path = "c:\\report.txt";
        ArrayList<String> listFromEngine = new ArrayList<>();

        File f = new File(path);
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()) {
            listFromEngine.add(scanner.next());
        }
        ArrayList<String[]> cars = new ArrayList<>();
        for (int i = 0; i < listFromEngine.size(); i++) {
            cars.add(listFromEngine.get(i).split(" "));
        }
        return cars;
    }


}
