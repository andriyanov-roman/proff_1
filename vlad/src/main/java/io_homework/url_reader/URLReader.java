package io_homework.url_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLReader {
    public URLReader() {
    }

    public void readPage(String path) {
        try {
            URL url = new URL(path);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String page;
            while ((page = in.readLine()) != null)
                System.out.println(page);

            in.close();
        } catch (IOException e) {

        }
    }
}
