package university_get_set;

import java.util.ArrayList;

public class TeacherData {
    public ArrayList<Teacher> getTeacher () {

        Teacher t = new Teacher();
        t.setName("Elena");
        t.setSecondName("Olegovna");
        t.setSalary(3000);
        t.setExpirence(5);
        t.setSex("woman");

        Teacher t1 = new Teacher();
        t1.setName("Yulia");
        t1.setSecondName("Agro");
        t1.setSalary(3100);
        t1.setExpirence(6);
        t1.setSex("woman");

        Teacher t2 = new Teacher();
        t2.setName("Sveta");
        t2.setSecondName("Kosenok");
        t2.setSalary(3101);
        t2.setExpirence(8);
        t2.setSex("woman");
        ArrayList<Teacher> listTeacher = new ArrayList<Teacher>();
        listTeacher.add(t);
        listTeacher.add(t1);
        listTeacher.add(t2);
        return listTeacher;
}
    }
