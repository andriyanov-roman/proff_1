package plain_cars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Plant {


    public ArrayList<String> carsListColor()throws FileNotFoundException {
        File f = new File("C:\\Users\\Алан\\Desktop\\Plant.txt");
        Scanner s = new Scanner(f);
        String temp = s.next();
        String [] array = temp.split("|");
        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            strings.add(array[i]);
        }


        return strings;
    }
    public ArrayList<Car> carArrayList() throws  FileNotFoundException{
      ArrayList<Car> cars = new ArrayList<Car>();
        for (int i = 0; i <carsListColor().size() ; i++) {


        }
        return null;
    }


}

