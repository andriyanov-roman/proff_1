package excep_pkg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsModel {

    public static void writeToFile(Goods good) throws IOException {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src\\GoodsList.txt", true)));
            out.println(good);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
