package printExp;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class StairsPrint implements IPrint {
    String path = "c:\\dec.txt";

    @Override
    public void print() throws IOException {
        String tmp = readFromFile();
        String[] arrStr = tmp.split(" ");
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println(arrStr[i]);
        }
    }

    @Override
    public String readFromFile() throws IOException {
        String stingFromFile = "";
        Scanner s = new Scanner(new File(path));
        while (s.hasNext()) {
            stingFromFile += s.nextLine() + "\r\n";
        }
        s.close();
        return stingFromFile;
    }
}


