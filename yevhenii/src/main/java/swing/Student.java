package swing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by eugene on 20.11.14.
 */
public class Student implements Comparable<Student> {


    private String name;
    private String surname;
    private ArrayList<Integer> marks = new ArrayList();
    private ArrayList subjectsStud = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList marks) {
        this.marks = marks;
    }

    public ArrayList getSubjectsStud() {
        return subjectsStud;
    }

    public void setSubjectsStud(ArrayList subjectsStud) {
        this.subjectsStud = subjectsStud;

    }

    public void writeStudents(ArrayList<Student> list, String path) {

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            for (int i = 0; i < list.size(); i++) {
                out.println(list.get(i).toString());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OK!");
    }

    public int getHighMark() {

        int tmp = 0;
        for (int i = 0; i < this.getMarks().size(); i++) {
            tmp += this.getMarks().get(i);

        }
        return tmp / this.getMarks().size();
    }

    public String toString() {
        return name + ":" + surname + ":" + marks;
    }


    @Override
    public int compareTo(Student o) {
        if (this.name.length() < o.name.length()) {
            return 1;
        } else if (this.name.length() > o.name.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}



