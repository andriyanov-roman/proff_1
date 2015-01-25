package university_get_set;
public class Worker {
    private String name;
    private String secondName;
    private int salary;
    private  int expirence;
    private  String sex;
     public String getName(){
         return name;
     }
    public void setName (String name){
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExpirence() {
        return expirence;
    }

    public void setExpirence(int expirence) {
        this.expirence = expirence;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
