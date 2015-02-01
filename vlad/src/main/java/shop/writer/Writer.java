package shop.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {

    public static <T> void writeToFile(T any, String path) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter(path, true)));
            out.println(any);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
