package university;

import java.util.ArrayList;

public class SisAdminData {

    public ArrayList<SisAdmin> getSis() {
        SisAdminData sis = new SisAdminData();

        SisAdmin s = new SisAdmin();
        s.setName("Yura");
        s.setExperience(9);
        s.setSalary(2000);
        s.setSex("men");

        SisAdmin sisAdmin2 = new SisAdmin();
        sisAdmin2.setName("Fredy");
        sisAdmin2.setSalary(2100);
        sisAdmin2.setExperience(8);
        sisAdmin2.setSex("men");

        SisAdmin sisAdmin3 = new SisAdmin();
        sisAdmin3.setName("Hyst");
        sisAdmin3.setSalary(2300);
        sisAdmin3.setExperience(7);
        sisAdmin3.setSex("women");

        ArrayList<SisAdmin> sisAdmins = new ArrayList<>();
        sisAdmins.add(s);
        sisAdmins.add(sisAdmin2);
        sisAdmins.add(sisAdmin3);

        return sisAdmins;
    }
    public SisAdmin maxSisAdmin(ArrayList<SisAdmin> sis) {
        SisAdmin tmp = sis.get(0);
        for (int i = 0; i < sis.size(); i++) {
            if (tmp.getSalary() < sis.get(i).getSalary()) {
                tmp = sis.get(i);
            }
        }
        return tmp;
    }
}
