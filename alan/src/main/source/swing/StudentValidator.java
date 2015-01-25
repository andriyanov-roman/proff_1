package swing;

import university_get_set.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentValidator extends Validator {
    private boolean isComponentsValidated = false;
    public static final String PATTERN_FOR_NAME = "([A-Z]{1}[a-z]{2,15})";
    public static final String PATTERN_FOR_SECOND_NAME = "([A-Z]{1}[a-z]{2,15})";
    public static final String PATTERN_FOR_MARKS = "([A-Z]{1}[a-z]{2,15})";

    public StudentValidator(Component[] components) {
        super(components);
    }

    @Override
    public boolean isValidated() {
        if (isComponentsValidated) {
            return true;
        }
        return false;


    }

    public String getErrorComponent() {
        String name = isNameCorrect();
        String secondName = isSecondNameCorrect();
        ArrayList<Integer> marks =isMarksCorrect();
        if (isNameCorrect() == null) {
            return "Name field is not correct";
        }
        isComponentsValidated = true;
        Student s = new Student();
        s.setName(name);
        s.setSecondName(secondName);
        s.setMarks(marks);
        return "";
    }

    public String isNameCorrect() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("name".equals(getComponents()[i].getName())) {
                JTextField name = (JTextField) getComponents()[i];
                if (isTextFieldCorrect(PATTERN_FOR_NAME, name)) {
                    return isNameCorrect();
                }


            }
        }
        return null;
    }

    public String isSecondNameCorrect() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("SecondName".equals(getComponents()[i].getName())) {
                JTextField secondName = (JTextField) getComponents()[i];
                if (isTextFieldCorrect(PATTERN_FOR_SECOND_NAME, secondName)) {
                    return isSecondNameCorrect();
                }

            }

        }
        return null;
    }

    public ArrayList<Integer> isMarksCorrect() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("marks".equals(getComponents()[i].getName())) {
               JTextField marks = (JTextField)getComponents()[i];
                /*if (isMarksCorrect(PATTERN_FOR_MARKS, marks)){
                    return isMarksCorrect();
                }*/

            }

        }
        return null;
    }


}
