package swing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class StudentFrame extends JFrame {

    public StudentFrame() {
        setName("Student Frame");
        setSize(400, 500);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        add(panel1);
        addCheckBoxToFrame(panel1);

        addTextComponentsToFrame(panel);
        addButtonToFrame(panel);
        tabbedPane.addTab("Students", panel);
        tabbedPane.addTab("CheckBoxTest", panel1);


        add(tabbedPane);

        //addComponentsToFrame();

        setVisible(true);
    }

    /*private void addComponentsToFrame() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        add(controlPanel);


        addTextComponentsToFrame(controlPanel);
        addButtonToFrame(controlPanel);
        addCheckBoxToFrame(controlPanel);
    }*/
    public class Tabs {

    }

    private void addTextComponentsToFrame(JPanel panel) {
        JTextField fieldName = new JTextField(5);
        JLabel labelText = new JLabel("Name");
        fieldName.setName("Name");
        JLabel labelTextSecond = new JLabel("SecondName");
        JTextField fieldSecondName = new JTextField(5);
        fieldSecondName.setName("SecondName");
        JTextField fieldMarks = new JTextField(5);
        JLabel labelMarks = new JLabel("Marks");
        fieldMarks.setName("Marks");
        panel.add(labelText);
        panel.add(fieldName);//new GridBagConstraints(0,0,1,1,0.0,0.9,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,2,3,4),0,0)
        panel.add(labelTextSecond);
        panel.add(fieldSecondName);
        panel.add(labelMarks);
        panel.add(fieldMarks);

    }

    private void addButtonToFrame(JPanel panel) {
        JButton button = new JButton("Submit");
        button.addActionListener(new studentAction(panel));
        JButton button1 = new JButton("Report");
        button1.addActionListener(new reportAction(panel));
        panel.add(button1);
        panel.add(button);
    }

    private void addCheckBoxToFrame(JPanel panel) {
        JCheckBox reportButtonStud = new JCheckBox("Students report");
        reportButtonStud.setMnemonic(KeyEvent.VK_S);
        reportButtonStud.setSelected(false);

        JCheckBox reportButtonFig = new JCheckBox("Figures report");
        reportButtonFig.setMnemonic(KeyEvent.VK_F);
        reportButtonFig.setSelected(false);

        panel.add(reportButtonFig);
        panel.add(reportButtonStud);


    }

    private class studentAction implements ActionListener {
        private JPanel panel;

        public studentAction(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = new StudentValidator(panel.getComponents()).getErrorComponent();
            if (!message.isEmpty()) {
                JOptionPane.showMessageDialog(panel, message);
            } else {
                JOptionPane.showMessageDialog(panel, "All fields are correct");
            }
        }
    }

    private class reportAction implements ActionListener {
        private JPanel panel;
        public reportAction(JPanel panel){
            this.panel = panel;
        }
        @Override

        public void actionPerformed(ActionEvent e) {
            StudentsReport r = new StudentsReport();
            try {
                r.generateReport();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            JOptionPane.showMessageDialog(panel, "OK!");

        }


    }


    public static void main(String[] args) {
        new StudentFrame();
    }
}
