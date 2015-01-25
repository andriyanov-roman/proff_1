package university;


import java.util.ArrayList;

public class CleanManagerData {

    public ArrayList<CleanManager> getClean() {
        CleanManager cleamMen = new CleanManager();
        cleamMen.setName("Vova");
        cleamMen.setExperience(5);
        cleamMen.setSalary(500);
        cleamMen.setSex("men");

        CleanManager cleanManager2 = new CleanManager();
        cleanManager2.setName("Yota");
        cleanManager2.setSalary(600);
        cleanManager2.setExperience(4);
        cleanManager2.setSex("women");

        CleanManager cleanManager3 = new CleanManager();
        cleanManager3.setName("Tuti");
        cleanManager3.setSalary(700);
        cleanManager3.setExperience(7);
        cleanManager3.setSex("women");

        ArrayList<CleanManager> cleanManagers = new ArrayList<>();
        cleanManagers.add(cleamMen);
        cleanManagers.add(cleanManager2);
        cleanManagers.add(cleanManager3);
        return cleanManagers;

    }

    public CleanManager maxCleaner(ArrayList<CleanManager> clean) {
        CleanManager tmp = clean.get(0);
        for (int i = 0; i < clean.size(); i++) {
            if (tmp.getSalary() < clean.get(i).getSalary()) {
                tmp = clean.get(i);
            }
        }
        return tmp;
    }


}