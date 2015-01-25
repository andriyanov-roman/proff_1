package university;

import report.StudentReport;
import studentSort.sortStudentByAverageMarks;
import studentSort.sortStudentBySecondName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentData studentData = new StudentData();
        ArrayList<Student> stud = studentData.getStudents();
        Collections.sort(stud);
//        for (int i = 0; i < stud.size(); i++) {
//            System.out.println(stud.get(i).getName());
//        }

        Collections.sort(stud, new sortStudentBySecondName());
        for (int i = 0; i < stud.size(); i++) {
            System.out.println(stud.get(i).getSecondName());
        }
        Collections.sort(stud,new sortStudentByAverageMarks());


    }
}
