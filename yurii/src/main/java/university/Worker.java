package university;


import java.util.ArrayList;

public class Worker {

    public String name;
    public String sex;
    public int experience;
    public double salary;

    public String toString() {
        return getClass().getSimpleName() + ": " + name + ":" + salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    //    workerBigSixMonth(workers);
//    removeWomenFromList(workers, "women");
//    SisAdminData sisAdminData = new SisAdminData();
//    TeacherData teacherData = new TeacherData();
//    CleanManagerData cleanManagerData = new CleanManagerData();
//    ArrayList<Worker> workers = new ArrayList<>();
//    workers.addAll(sisAdminData.getSis());
//    workers.addAll(teacherData.getTeacher());
//    workers.addAll(cleanManagerData.getClean());
    private void removeWomenFromList(ArrayList<Worker> workers, String parameter) {
        ArrayList<Worker> tmp = new ArrayList<>();
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getSex().equals(parameter)) {
                tmp.add(workers.get(i));
            }
        }
        workers.removeAll(tmp);
        for (int i = 0; i < workers.size(); i++) {
            System.out.println(workers.get(i).getName());
        }
    }

    private void workerBigSixMonth(ArrayList<Worker> workers) {
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getExperience() > 6) {
                workers.get(i).setSalary((workers.get(i).getSalary() * 1.15));
            }
            System.out.println(workers.get(i).getSalary());
        }
    }
}
