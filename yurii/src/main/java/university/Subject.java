package university;

public class Subject {


    public String name;
    public int hours;
    public int semester;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (hours != subject.hours) return false;
        if (semester != subject.semester) return false;
        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + hours;
        result = 31 * result + semester;
        return result;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String toString() {
        return "" + name + ":" + hours + " hours";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


}
