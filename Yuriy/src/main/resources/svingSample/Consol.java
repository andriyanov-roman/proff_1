package svingSample;


import javax.swing.*;

public class Consol extends JFrame {

    StudentFrame sf = new StudentFrame();
    WorkerFrame wf = new WorkerFrame();
    CarsFrame cf = new CarsFrame();

    JPanel carsPanel = cf.getCarsPanel();
    JPanel studentPanel = sf.getPanel();
    JPanel workerPanel = wf.getPanel();

    JTabbedPane tabbedPane = new JTabbedPane();

    public Consol() {
        tabbedPane.add("Stuent", studentPanel);
        tabbedPane.add("Cars", carsPanel);
        tabbedPane.add("Worker", workerPanel);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        Consol consol = new Consol();
        consol.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        consol.setSize(700, 500);
        consol.setVisible(true);
    }

}
