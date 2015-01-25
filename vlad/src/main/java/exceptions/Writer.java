package exceptions;

/**
 * Created by root on 25.01.15.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {
    public static void writeToFile(Good good){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter("vlad/src/main/java/exceptions/shop", true)));
            out.println(good);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
