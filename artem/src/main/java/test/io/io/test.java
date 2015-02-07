package test.io.io;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class test {
    public static void main(String[] args) {
        ByteInputStream byteInputStream = new ByteInputStream();
        BufferedInputStream bufferedInputStream = null;
        try (InputStream inStream = new FileInputStream("")) {
            bufferedInputStream = new BufferedInputStream(inStream);
            int b;
            while (true) {
                b = inStream.read();
                if (b != -1) {
                    System.out.println((char) b);
                } else {
                    break;
                }
            }
        } catch (IOException| NullPointerException e) {
            e.printStackTrace();
        }

    }

}


