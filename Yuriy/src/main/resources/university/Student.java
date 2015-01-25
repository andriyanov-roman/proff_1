package university;

import java.util.ArrayList;

public class Student implements Comparable<Student> {

    public String name;
    public String secondName;
    public ArrayList<Integer> marks;
    public ArrayList<Subject> subjects;


    public String toString() {
        return "" + name + ":" + secondName + ":" + marks + ":" + subjects +"";
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }


    @Override
    public int compareTo(Student o) {
        if (this.name.length() < o.name.length()) {
            return 1;
        }
        if (this.name.length() > o.name.length()) {
            return -1;
        }
        return 0;
    }
}
