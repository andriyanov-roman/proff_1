package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentFrame extends JFrame {
    public String name = "Student name";

    public static void main(String[] args) {
        new StudentFrame();
    }

    public StudentFrame() {
        setName("Student Frame");
        setSize(400, 500);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponentsToFrame();
        setVisible(true);

    }

    private void addComponentsToFrame() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 2));
        add(controlPanel);
        addTextComponentsToFrame(controlPanel);


    }

    private void addTextComponentsToFrame(JPanel panel) {
        JLabel lableName = new JLabel("Имя");
        JTextField fieldName = new JTextField(5);
        fieldName.setName("name");

        JLabel lableSecondName = new JLabel("Фамилия");
        JTextField fieldSecondName = new JTextField(5);
        fieldSecondName.setName("secondName");

        JLabel labelMarks = new JLabel("Оценки");
        JTextField fieldMarks = new JTextField(5);
        fieldMarks.setName("marks");
        panel.add(lableName);
        panel.add(fieldName);
        panel.add(lableSecondName);
        panel.add(fieldSecondName);
        panel.add(labelMarks);
        panel.add(fieldMarks);


        addButton(panel);
    }

    private void addButton(JPanel jPanel) {
        JButton jButton = new JButton("Добавить");
        jButton.addActionListener(new StudentActionHandler(jPanel));
        jPanel.add(jButton);
        Component[] components = jPanel.getComponents();

    }

    private class StudentActionHandler implements ActionListener {
        private JPanel panel;

        public StudentActionHandler(JPanel panel) {
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
}








