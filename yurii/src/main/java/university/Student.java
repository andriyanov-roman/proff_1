package university;

import java.util.ArrayList;
import java.sql.Date;

public class Student implements Comparable<Student> {

    public String name;
    public String secondName;
    public ArrayList<Integer> marks;
    public ArrayList<Subject> subjects;
    public int stipend;
    public int kurs;
    public String city;
    public Date date;
    public int univers_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (kurs != student.kurs) return false;
        if (stipend != student.stipend) return false;
        if (univers_id != student.univers_id) return false;
        if (city != null ? !city.equals(student.city) : student.city != null) return false;
        if (date != null ? !date.equals(student.date) : student.date != null) return false;
        if (marks != null ? !marks.equals(student.marks) : student.marks != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (secondName != null ? !secondName.equals(student.secondName) : student.secondName != null) return false;
        if (subjects != null ? !subjects.equals(student.subjects) : student.subjects != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (marks != null ? marks.hashCode() : 0);
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        result = 31 * result + stipend;
        result = 31 * result + kurs;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + univers_id;
        return result;
    }

    public int getUnivers_id() {
        return univers_id;
    }

    public void setUnivers_id(int univers_id) {
        this.univers_id = univers_id;
    }

    public int getStipend() {
        return stipend;
    }

    public void setStipend(int stipend) {
        this.stipend = stipend;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", marks=" + marks +
                ", subjects=" + subjects +
                ", stipend=" + stipend +
                ", kurs=" + kurs +
                ", city='" + city + '\'' +
                ", date=" + date +
                '}';
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
