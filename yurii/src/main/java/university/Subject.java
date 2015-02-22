package university;

public class Subject {


    public String name;
    public int hours;


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
