package university_get_set;

import java.util.ArrayList;

public class SysadminData {

    public ArrayList<Sysadmin> getSysadmin() {

        Sysadmin s = new Sysadmin();
        s.setName("Sanya");
        s.setSecondName("Semenovich");
        s.setSalary(3600);
        s.setExpirence(7);

        Sysadmin s1 = new Sysadmin();
        s1.setName("Leha");
        s1.setSecondName("Agro");
        s1.setSalary(3605);
        s1.setExpirence(4);

        Sysadmin s2 = new Sysadmin();
        s2.setName("Loh");
        s2.setSecondName("Kosenok");
        s2.setSalary(4000);
        s2.setExpirence(5);

        ArrayList<Sysadmin> sysadminArrayList = new ArrayList<Sysadmin>();
        sysadminArrayList.add(s);
        sysadminArrayList.add(s1);
        sysadminArrayList.add(s2);
        return sysadminArrayList;
    }
}
