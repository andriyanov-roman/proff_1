package tests.io;

import java.io.*;

public class Main {
    public static void main(String[] args) {

    }
    public void ioTest() {
        try (InputStream inStream = new FileInputStream("/home/vladislav/proff_repos/proff_1/vlad/src/main/java/files/test");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inStream)) {
            int b;
            while (true) {
                b = bufferedInputStream.read();
                if (b != -1) {
                    System.out.print((char) b);
                } else {
                    break;
                }
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

}
