package tests.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inStream = new FileInputStream
                    ("/home/vladislav/proff_repos/proff_1/vlad/src/main/java/files/test");
            bufferedInputStream = new BufferedInputStream(inStream);
            int b;
            while (true) {
                b = bufferedInputStream.read();
                if (b != -1) {
                    System.out.println((char) b);
                } else
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inStream != null)
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
