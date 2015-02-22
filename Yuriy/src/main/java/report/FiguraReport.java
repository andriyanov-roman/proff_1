package report;

import figurs.Circle;
import figurs.Figura;
import figurs.Square;
import figurs.Triangle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FiguraReport extends Report {
    ArrayList<FigureHelper> figures = new ArrayList<>();

    @Override
    public void genereteReport() throws IOException {
        Figura t1 = new Triangle(5, 12, "Trian");
        Figura s1 = new Square("Kvad", 55);
        Figura c1 = new Circle("Krug", 6);

        ArrayList<Figura> listFigurs = new ArrayList<>();
        listFigurs.add(t1);
        listFigurs.add(s1);
        listFigurs.add(c1);
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src\\ListFigurs.txt")));
            for (int i = 0; i < listFigurs.size(); i++) {
                out.println(listFigurs.get(i).getName() + ":" + listFigurs.get(i).getPerimeter());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void generateSortFigursFromPerimeter() throws IOException {
        FigureHelper helper = new FigureHelper();
        helper.getFigurs();
        for (int i = 0; i < figures.size(); i++) {
            for (int j = 0; j < figures.size() - 1; j++) {
                if (figures.get(j).perimeter > figures.get(j + 1).perimeter) {
                    FigureHelper tmp = figures.get(j);
                    figures.set(j, figures.get(j + 1));
                    figures.set(j + 1, tmp);
                }
            }
        }
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src\\SortFigurs.txt")));
            for (int i = 0; i < figures.size(); i++) {
                out.println(figures.get(i).toString());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class FigureHelper {
        String name;
        double perimeter;

        public void getFigurs() throws IOException {
            ArrayList<String[]> lines = getString("c:\\ListFigurs.txt");
            for (int i = 0; i < lines.size(); i++) {
                FigureHelper f = new FigureHelper();
                f.name = lines.get(i)[0];
                double perim = Double.parseDouble(lines.get(i)[1]);
                f.perimeter = perim;
                figures.add(f);
            }
        }

        public String toString() {
            return name + ":" + perimeter;
        }

    }


    private class FigureHelper2 {
        private static final int NAME = 0;
        private static final int PERIMETER = 1;


        public void getFigurs() throws IOException {

            ArrayList<String[]> lines = getString("src\\ListFigurs.txt");
            for (int i = 0; i < lines.size(); i++) {
                FigureHelper f = new FigureHelper();
                f.name = lines.get(i)[NAME];
                double perim = Double.parseDouble(lines.get(i)[PERIMETER]);
                f.perimeter = perim;
                figures.add(f);
            }
        }
    }

}