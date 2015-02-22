package shop.dbAccessAndOthersSamples;

import shop.Good;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsModel {

    public static void writeToFile(Good good) throws IOException {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Yuriy/src/main/files/goods.txt", true)));
            out.println(good);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
