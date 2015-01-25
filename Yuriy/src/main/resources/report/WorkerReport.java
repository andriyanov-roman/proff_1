package report;

import university.UniversityData;
import university.Worker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WorkerReport extends Report {
    @Override

    public void genereteReport() {
        UniversityData universityData = new UniversityData();
        ArrayList<Worker> workers = universityData.getWorkers();
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("c:\\Worker.txt")));
            for (int i = 0; i < workers.size(); i++) {
                out.println(workers.get(i).toString());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
