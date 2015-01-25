package figurs;

import report.FiguraReport;
import report.WorkerReport;
import trailStation.Station;


import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

//        FiguraReport figuraReport = new FiguraReport();
//        figuraReport.genereteReport();
//        figuraReport.generateSortFigursFromPerimeter();
//        WorkerReport workerReport = new WorkerReport();
//        workerReport.genereteReport();

        Station station = new Station();
        station.checkPassengersList();


    }


    public static Figura figuraWithMaxPerimeter(ArrayList<Figura> listFigurs) {
        Figura max = listFigurs.get(0);
        for (int i = 0; i < listFigurs.size(); i++) {
            if (max.getPerimeter() < listFigurs.get(i).getPerimeter()) {
                max = listFigurs.get(i);
            }
        }
        return max;
    }
}
