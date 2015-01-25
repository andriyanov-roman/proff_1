package svingSample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsFrame extends JFrame {

    public JPanel getCarsPanel() {

        JPanel carsPanel = new JPanel();
        GridLayout grid = new GridLayout(4, 4);
        carsPanel.setLayout(grid);

        JLabel bodyLabel = new JLabel("Body");
        JTextField bodyTextField = new JTextField(5);
        bodyTextField.setName("body");
        JTextField bodyPriceField = new JTextField(5);
        bodyPriceField.setName("bodyPrice");
        JLabel colorLabel = new JLabel("Color");
        JTextField colorTextField = new JTextField(5);
        colorTextField.setName("color");
        JTextField colorPrice = new JTextField(5);
        colorPrice.setName("colorPrice");
        JLabel engineLabel = new JLabel("Engine");
        JTextField engineTextFild = new JTextField(5);
        engineTextFild.setName("engine");
        JTextField enginePrice = new JTextField(5);
        enginePrice.setName("enginePrice");
        JButton button = new JButton("Create car");

        carsPanel.add(bodyLabel);
        carsPanel.add(bodyTextField);
        carsPanel.add(bodyPriceField);
        carsPanel.add(colorLabel);
        carsPanel.add(colorTextField);
        carsPanel.add(colorPrice);
        carsPanel.add(engineLabel);
        carsPanel.add(engineTextFild);
        carsPanel.add(enginePrice);
        carsPanel.add(button);

        add(carsPanel);
        return carsPanel;
    }

    private class CarsActionHendler implements ActionListener {
        private JPanel panel;

        public CarsActionHendler(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
     //   String message = new CarsValidator()
        }
    }


}
