package report;

import java.io.IOException;

public class MainReport {
    public static void main(String[] args) throws IOException {
        Report r = new Report() {
            @Override
            public void genereteReport() throws IOException {
            }
        };
            ReportCarsReverse rr = new ReportCarsReverse();
            rr.generateReport();

    }


}
