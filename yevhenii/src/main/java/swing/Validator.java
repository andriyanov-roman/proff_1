package swing;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {
    public static final String PATTERN_FOR_NAME = "([A-Z]{1}[a-z]{2,15})";
    public static final String PATTERN_FOR_MARKS = "(([0-9]{1}[\\W]{1}){1,20})";

    private Component[] components;

    public Validator(Component[] components) {
        this.components = components;
    }

    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
    }

    public boolean isTextFieldCorrect(String pattern, String textField) {
        Matcher matcher = Pattern.compile(pattern).matcher(textField);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public abstract boolean isValidated();

    public void writeToFile(Object anyObject) {
        if (isValidated()) {
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/home/eugene/leleka", true)));
                out.println(anyObject.toString());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

