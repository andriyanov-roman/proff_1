package university;

import java.util.ArrayList;

public class Teacher extends Worker {


    public ArrayList<Subject> subjects;
    public ArrayList<Student> students;






    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }


    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }




}
