package report;


import java.util.ArrayList;

public interface IReportMaker<T> {

    public ArrayList<T> genereteReport();
    public String getPath();

}
