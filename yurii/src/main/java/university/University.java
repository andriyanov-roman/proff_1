package university;


import java.util.ArrayList;

public class University {

    public String name;
    public ArrayList<Student> studentslist;
    public ArrayList<Subject> subjectlist;
    public ArrayList<Worker> workers = new ArrayList<>();
    public int rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        University that = (University) o;

        if (rating != that.rating) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (studentslist != null ? !studentslist.equals(that.studentslist) : that.studentslist != null) return false;
        if (subjectlist != null ? !subjectlist.equals(that.subjectlist) : that.subjectlist != null) return false;
        if (workers != null ? !workers.equals(that.workers) : that.workers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (studentslist != null ? studentslist.hashCode() : 0);
        result = 31 * result + (subjectlist != null ? subjectlist.hashCode() : 0);
        result = 31 * result + (workers != null ? workers.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

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
