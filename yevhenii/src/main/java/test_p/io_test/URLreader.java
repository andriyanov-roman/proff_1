package test_p.io_test;

import javax.sound.sampled.AudioInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by eugene on 31.01.15.
 */
public class URLreader {
    public static void main(String[] args) {

    }

    public void UrlReader() {
        InputStream inStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {

            inStream = new FileInputStream("www.ex.ua/85638019?r=39323,23779");
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
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}

