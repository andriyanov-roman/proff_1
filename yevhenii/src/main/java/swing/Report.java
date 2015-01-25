package swing;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eugene on 06.12.14.
 */
public abstract class Report {

    public ArrayList<String[]> getStrings(String path) throws FileNotFoundException, IOException {
        ArrayList<String[]> arrayList = new ArrayList<>();
        File f = new File(path);
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()) {
            arrayList.add(scanner.next().split(":"));

        }

        return arrayList;
    }

    public abstract void generateReport() throws IOException;
}

