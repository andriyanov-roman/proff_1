package report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Report {

    public ArrayList<String[]> getString(String path) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : Files.readAllLines(Paths.get(path))) {
            strings.add(s);
        }
        ArrayList<String[]> stringsSplit = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            stringsSplit.add(strings.get(i).split(":"));
        }
        return stringsSplit;
    }


    public abstract void genereteReport() throws IOException;


}
