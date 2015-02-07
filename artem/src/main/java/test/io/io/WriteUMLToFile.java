package test.io.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by artem on 31.01.15.
 */
public class WriteUMLToFile {
    public static void main(String[] args) throws IOException{
        URL website = new URL("https://chrome.google.com/webstore/category/apps?hl=ru");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("/home/artem/proff_repos/proff_1/artem/src/main/java/test/io/test");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }

}
