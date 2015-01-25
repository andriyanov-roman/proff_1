package swing;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class StudentValidator extends Validator {
    private boolean isComponentsValidated = false;

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
        String name = getStudentName();
        String secondName = getSecondNameCorrect();
        ArrayList<Integer> marks = getMarksCorrect();
        if (name == null) {
            return "Name field is not correct";
        } else if (secondName == null) {
            return "SecondName field is not correct";
        } else if (marks == null) {
            return "Marks field is not correct";
        }
        isComponentsValidated = true;
        Student s = new Student();
        s.setName(name);
        s.setSurname(secondName);
        s.setMarks(marks);
        writeToFile(s);
        return "";
    }

    public String getStudentName() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("Name".equals(getComponents()[i].getName())) {
                JTextField jName = (JTextField) getComponents()[i];
                String name = jName.getText();
                if (isTextFieldCorrect(PATTERN_FOR_NAME, name)) {
                    return name;
                }
            }
        }
        return null;
    }

    public String getSecondNameCorrect() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("SecondName".equals(getComponents()[i].getName())) {
                JTextField jSecondName = (JTextField) getComponents()[i];
                String secondName = jSecondName.getText();
                if (isTextFieldCorrect(PATTERN_FOR_NAME, secondName)) {
                    return secondName;
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> getMarksCorrect() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("Marks".equals(getComponents()[i].getName())) {
                JTextField jMarks = (JTextField) getComponents()[i];
                String marks = jMarks.getText();
                if (isTextFieldCorrect(PATTERN_FOR_MARKS, marks)) {
                    String[] marks1 = marks.split("\\W");
                    ArrayList<Integer> marksList = new ArrayList<>();
                    for (int j = 0; j < marks1.length; j++) {
                        if (!marks1[j].isEmpty()) {
                            marksList.add(Integer.parseInt(marks1[j]));
                        }
                    }
                    return marksList;
                }
            }
        }
        return null;
    }


}
