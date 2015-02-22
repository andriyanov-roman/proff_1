package svingSample;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarsValidator extends Validator {

    private boolean isComponentsValidated = false;

    public CarsValidator(Component[] components) {
        super(components);
    }

    @Override
    public boolean isValidated() {
        if (isComponentsValidated) {
            return true;
        }
        return false;
    }

    @Override
    public void writeToFile(Object anyObject) {

    }

    public String getErrorComponent() {
        String body = getBody();
        String color = getColor();
        String engine = getEngine();
        ArrayList<Integer> bodyPrice = getBodyPrice();
        ArrayList<Integer> colorPrice = getColorPrice();
        ArrayList<Integer> enginePrice = getEnginePrice();

        return "";
    }

    public String getBody() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("body".equals(getComponents()[i].getName())) {
                JTextField jBody = (JTextField) getComponents()[i];
                String bodyType = jBody.getText();
                if (isTextFieldCorrect(PATTERN_FOR_CARS, bodyType)) {
                    return bodyType;
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> getBodyPrice() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("bodyPrice".equals(getComponents()[i].getName())) {
                JTextField jPrice = (JTextField) getComponents()[i];
                String prices = jPrice.getText();
                String[] splitPrice = prices.split(",");
                ArrayList<Integer> priceList = new ArrayList<>();
                for (String price : splitPrice) {
                    priceList.add(Integer.parseInt(price));
                }
                if (isTextFieldCorrect(PATTERN_FOR_NUMBERS, prices)) {
                    return priceList;
                }
            }
        }
        return null;
    }

    public String getColor() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("color".equals(getComponents()[i].getName())) {
                JTextField jColor = (JTextField) getComponents()[i];
                String color = jColor.getText();
                if (isTextFieldCorrect(PATTERN_FOR_CARS, color)) {
                    return color;
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> getColorPrice() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("colorPrice".equals(getComponents()[i].getName())) {
                JTextField jPrice = (JTextField) getComponents()[i];
                String prices = jPrice.getText();
                String[] splitPrice = prices.split(",");
                ArrayList<Integer> priceList = new ArrayList<>();
                for (String price : splitPrice) {
                    priceList.add(Integer.parseInt(price));
                }
                if (isTextFieldCorrect(PATTERN_FOR_NUMBERS, prices)) {
                    return priceList;
                }
            }
        }
        return null;
    }

    public String getEngine() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("engine".equals(getComponents()[i].getName())) {
                JTextField jEngine = (JTextField) getComponents()[i];
                String engine = jEngine.getText();
                if (isTextFieldCorrect(PATTERN_FOR_CARS, engine)) {
                    return engine;
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> getEnginePrice() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("enginePrice".equals(getComponents()[i].getName())) {
                JTextField jPrice = (JTextField) getComponents()[i];
                String prices = jPrice.getText();
                String[] splitPrice = prices.split(",");
                ArrayList<Integer> priceList = new ArrayList<>();
                for (String price : splitPrice) {
                    priceList.add(Integer.parseInt(price));
                }
                if (isTextFieldCorrect(PATTERN_FOR_NUMBERS, prices)) {
                    return priceList;
                }
            }
        }

        return null;
    }


}
