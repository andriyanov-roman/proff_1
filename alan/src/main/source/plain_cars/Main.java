package plain_cars;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File c = new File("C:\\Users\\Алан\\Desktop\\Color.txt");
        Scanner s1 = new Scanner(c);
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<String[]> colorType = new ArrayList<String[]>();
        while(s1.hasNext()) {
            strings.add(s1.next());
        }
        for (int i = 0; i < strings.size(); i++) {
            colorType.add(strings.get(i).split(":"));
        }
        ArrayList<Color> colors = new ArrayList<Color>();
        for (int i = 0; i < colorType.size(); i++) {
            Color color = new Color();
            color.setName(colorType.get(i)[0]);
            color.setPrice(new BigDecimal(colorType.get(i)[1]));
            colors.add(color);
        }
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i).getName() + " " + colors.get(i).getPrice());
        }
    }
}
