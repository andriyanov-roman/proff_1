package university;


import java.util.ArrayList;

public class University {

    public String name;
    public ArrayList<Student> studentslist;
    public ArrayList<Subject> subjectlist;
    public ArrayList<Worker> workers = new ArrayList<>();




    public ArrayList<Worker> getWorkers() {
        return workers;
    }
    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public ArrayList<Subject> getSubjectlist() {
        return subjectlist;
    }

    public void setSubjectlist(ArrayList<Subject> subjectlist) {
        this.subjectlist = subjectlist;
    }


    public ArrayList<Student> getStudentslist() {
        return studentslist;
    }

    public void setStudentslist(ArrayList<Student> studentslist) {
        this.studentslist = studentslist;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
