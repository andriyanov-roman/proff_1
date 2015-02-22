package studentSort;

import university.Student;

import java.util.Comparator;

public class sortStudentBySecondName implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        if (o1.secondName.length() < o2.secondName.length()) {
            return 1;
        }
        if (o1.secondName.length() > o2.secondName.length()) {
            return -1;
        }
        return 0;
    }
}
