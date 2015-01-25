package University;


public class SubjectData {
    public Subject [] getSubjects () {
        SubjectData sd = new SubjectData();


        Subject math = new Subject();
        math.name = "Math";
        math.hours = 40;

        Subject oop = new Subject();
        oop.name = "Oop";
        oop.hours = 108;

        Subject vpi = new Subject();
        oop.name = "Vpi";
        oop.hours = 118;

        Subject pppi = new Subject();
        oop.name = "Pppi";
        oop.hours = 108;

        Subject asd = new Subject();
        oop.name = "Asd";
        oop.hours = 108;
        return new Subject [] {math, oop, vpi, asd, pppi};
    }
    public Subject getSubjectsName (String math){
        Subject[] sub = getSubjects();
        for (int i = 0; i < sub.length ; i++) {
            if (sub[i].name.equals(i));
            return sub[i];
        }
        return null;
    }

}
