package svingSample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StudentFrame extends JFrame  {

//    public static void main(String[] args) {
//        new StudentFrame();
//    }
//    public StudentFrame() {
//        setLayout(new CardLayout());
//        setTitle("Student");
//        setSize(400, 500);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        getPanel();
//        setVisible(true);
//   }

    public JPanel getPanel() {
        JPanel controlPanel = new JPanel();
        GridLayout gL = new GridLayout(6, 6);
        controlPanel.setLayout(gL);
        add(controlPanel);
        addTextComponentsToFrame(controlPanel);
        return controlPanel;
    }

    private void addTextComponentsToFrame(JPanel panel) {
        JLabel labelName = new JLabel("Name");
        JTextField fieldName = new JTextField(5);
        fieldName.setName("name");
        JLabel labelSecondName = new JLabel("Second Name");
        JTextField fieldSecondName = new JTextField(5);
        fieldSecondName.setName("Second Name");
        JLabel labelMarks = new JLabel("Marks");
        JTextField fieldMarks = new JTextField(5);
        fieldMarks.setName("Marks");
        JLabel labelSubject = new JLabel("Subject");
        JTextField fieldSubject = new JTextField(5);
        fieldSubject.setName("Subject");
        JLabel labelHours = new JLabel("Hours_Subject");
        JTextField fieldHours = new JTextField(5);
        fieldHours.setName("Hours_Subject");

        panel.add(labelName);
        panel.add(fieldName);
        panel.add(labelSecondName);
        panel.add(fieldSecondName);
        panel.add(labelMarks);
        panel.add(fieldMarks);
        panel.add(labelSubject);
        panel.add(fieldSubject);
        panel.add(labelHours);
        panel.add(fieldHours);

        addButtonToFrame(panel);
    }

    private void addButtonToFrame(JPanel panel) {
        JButton button = new JButton("OK");
        button.addActionListener(new StudentActionHandler(panel));
        JButton subjectButton = new JButton("Add Subject");
        subjectButton.addActionListener(new StudentActionHandler(panel));
        panel.add(button);
        panel.add(subjectButton);
    }


    private class StudentActionHandler implements ActionListener {
        private JPanel panel;

        public StudentActionHandler(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = null;
            try {
                message = new StudentValidator(panel.getComponents()).getErrorComponent();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (!message.isEmpty()) {
                JOptionPane.showMessageDialog(panel, message);
            } else {
                JOptionPane.showMessageDialog(panel, "All fields are correct");
            }
        }
    }
}


