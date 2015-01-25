package university_get_set;

import java.util.ArrayList;

public class CleanerData {
    public ArrayList<Cleaner> getCleaner() {
        Cleaner c = new Cleaner();
        c.setName("Ivan");
        c.setSecondName("Semenovich");
        c.setSalary(2500);
        c.setExpirence(2);

        Cleaner c1 = new Cleaner();
        c1.setName("Yura");
        c1.setSecondName("Agro");
        c1.setSalary(2505);
        c1.setExpirence(5);

        Cleaner c2 = new Cleaner();
        c2.setName("Sergey");
        c2.setSecondName("Kosenok");
        c2.setSalary(2510);
        c2.setExpirence(10);
        ArrayList<Cleaner> cleanerArrayList = new ArrayList<Cleaner>();
        cleanerArrayList.add(c);
        cleanerArrayList.add(c1);
        cleanerArrayList.add(c2);
        return cleanerArrayList;
    }
}
