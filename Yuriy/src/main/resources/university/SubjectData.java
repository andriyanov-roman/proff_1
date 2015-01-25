package university;


import java.util.ArrayList;

public class SubjectData {

    public ArrayList<Subject> getData() {

        Subject math = new Subject();
        math.setName("Math");
        math.setHours(40);

        Subject himi = new Subject();
        himi.setName("Himi");
        himi.setHours(35);

        Subject phizra = new Subject();
        phizra.setName("Phizra");
        phizra.setHours(37);

        Subject litra = new Subject();
        litra.setName("Litra");
        litra.setHours(45);

        Subject geo = new Subject();
        geo.setName("Geo");
        geo.setHours(42);

        ArrayList <Subject> subjects = new ArrayList<>();
        subjects.add(math);
        subjects.add(himi);
        subjects.add(phizra);
        subjects.add(litra);
        subjects.add(geo);

        return subjects;
    }


    public Subject getSubjectByName(String name) {         // возвращвет екземпляр класса сабжект
        for (int i = 0; i < getData().size(); i++) {
            if (getData().get(i).getName().equals(name)) {
                return getData().get(i);
            }
        }
        return null;
    }
}
