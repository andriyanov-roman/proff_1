package university_get_set;

import java.util.ArrayList;

public class University {
    private String name;
    private String listSubjects;
    private String listStudents;
    private String listEmployees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListSubjects() {
        return listSubjects;
    }

    public void setListSubjects(String listSubjects) {
        this.listSubjects = listSubjects;
    }

    public String getListStudents() {
        return listStudents;
    }

    public void setListStudents(String listStudents) {
        this.listStudents = listStudents;
    }

    public String getListEmployees() {
        return listEmployees;
    }

    public void setListEmployees(String listEmployees) {
        this.listEmployees = listEmployees;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public ArrayList<Worker> workers = new ArrayList<Worker>();
}
