package swing;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {
    Component [] components;


    public Validator(Component[] components) {
        this.components = components;
    }



    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
    }

    public boolean isTextFieldCorrect(String pattern, JTextField textField) {

            Matcher matcher = Pattern.compile(pattern).matcher(textField.getText());
            if (matcher.matches()) {
                return true;
            }

        return false;
    }
    public abstract boolean isValidated();

    public void writeToFile() {
        if(isValidated()) {

        }
    }


}
