package svingSample;

import org.omg.CORBA.*;
import university.Student;
import university.Subject;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Object;
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

    @Override
    public void writeToFile(Object anyObject) {
        if (isValidated()){
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("c:\\student.txt")));
                System.out.println(anyObject.toString());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getErrorComponent() throws IOException {
        String name = getStudentName();
        String secondName = getSecondName();
        ArrayList<Integer> marks = getMarks();
        ArrayList<Subject> subject = getSubject();
        int subjectHours = getHourSubject();
        if (name == null) {
            return "Name field is not correct !!! ";
        }
        if (secondName == null) {
            return "SecondName field is not correct";
        }
        if (marks == null) {
            return "Marks field is not correct";
        }
        if (subject == null) {
            return "Subject field is not correct";
        }
        if (subjectHours == 0) {
            return "Subject hours field is not correct";
        }
        isComponentsValidated = true;
        Student s = new Student();
        s.setName(name);
        s.setSecondName(secondName);
        s.setMarks(marks);
        s.setSubjects(subject);

        writeToFile(s);
        return "";
    }

    public String getStudentName() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("name".equals(getComponents()[i].getName())) {
                JTextField jName = (JTextField) getComponents()[i];
                String studentName = jName.getText();
                if (isTextFieldCorrect(PATTERN_FOR_NAME, studentName)) {
                    return studentName;
                }
            }
        }
        return null;
    }

    public String getSecondName() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("Second Name".equals(getComponents()[i].getName())) {
                JTextField jSecondName = (JTextField) getComponents()[i];
                String secondName = jSecondName.getText();
                if (isTextFieldCorrect(PATTERN_FOR_NAME, secondName)) {
                    return secondName;
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> getMarks() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("Marks".equals(getComponents()[i].getName())) {
                JTextField jmarks = (JTextField) getComponents()[i];
                String marks = jmarks.getText();
                String[] splitMarks = marks.split(",");
                ArrayList<Integer> markList = new ArrayList<>();
                for (String mark : splitMarks) {
                    markList.add(Integer.parseInt(mark));
                }
                if (isTextFieldCorrect(PATTERN_FOR_NUMBERS, marks)) {
                    return markList;
                }
            }
        }
        return null;
    }

    public ArrayList<Subject> getSubject() {
        ArrayList<Subject> subjList = new ArrayList<>();
        for (int i = 0; i < getComponents().length; i++) {
            if ("Subject".equals(getComponents()[i].getName())) {
                JTextField jSubj = (JTextField) getComponents()[i];
                String studentSubj = jSubj.getText();

                Subject s = new Subject();
                s.setName(studentSubj);
                subjList.add(s);
                if (isTextFieldCorrect(PATTERN_FOR_NAME, studentSubj)) {
                    return subjList;
                }
            }
        }
        return null;
    }

    public int getHourSubject() {
        for (int i = 0; i < getComponents().length; i++) {
            if ("Hours_Subject".equals(getComponents()[i].getName())) {
                JTextField jHour = (JTextField) getComponents()[i];
                String tmp = jHour.getText();
                int hours = Integer.parseInt(tmp);
                if (isTextFieldCorrect(PATTERN_FOR_NUMBERS, tmp)) {
                    return hours;
                }
            }
        }
        return 0;
    }


}
