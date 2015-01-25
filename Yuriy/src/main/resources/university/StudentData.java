package university;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentData {
    static String path = "c:\\studentReport.txt";

    public ArrayList<Student> getStudents() {

        SubjectData subjectData = new SubjectData();

        ArrayList<Subject> sS = new ArrayList<>();
        sS.add(subjectData.getSubjectByName("Math"));
        sS.add(subjectData.getSubjectByName("Himi"));


        ArrayList<Subject> s1S = new ArrayList<>();
        s1S.add(subjectData.getSubjectByName("Litra"));
        s1S.add(subjectData.getSubjectByName("Math"));

        ArrayList<Subject> s2S = new ArrayList<>();
        s2S.add(subjectData.getSubjectByName("Himi"));

        ArrayList<Subject> s3S = new ArrayList<>();
        s3S.add(subjectData.getSubjectByName("Phizra"));
        s3S.add(subjectData.getSubjectByName("Geo"));

        ArrayList<Subject> s4S = new ArrayList<>();
        s4S.add(subjectData.getSubjectByName("Geo"));
        s4S.add(subjectData.getSubjectByName("Himi"));

        ArrayList<Integer> integList = new ArrayList<>();
        integList.add(6);
        integList.add(5);
        integList.add(4);

        ArrayList<Integer> integList1 = new ArrayList<>();
        integList1.add(3);
        integList1.add(3);
        integList1.add(3);

        ArrayList<Integer> integList2 = new ArrayList<>();
        integList2.add(5);
        integList2.add(5);
        integList2.add(5);

        ArrayList<Integer> integList3 = new ArrayList<>();
        integList3.add(4);
        integList3.add(4);
        integList3.add(2);

        ArrayList<Integer> integList4 = new ArrayList<>();
        integList4.add(6);
        integList4.add(7);
        integList4.add(3);

        Student s = new Student();
        s.setName("Ivan");
        s.setSecondName("Ivanov");
        s.setMarks(integList);
        s.setSubjects(sS);

        Student s1 = new Student();
        s1.setName("Vasya");
        s1.setSecondName("Vasukov");
        s1.setMarks(integList1);
        s1.setSubjects(s1S);

        Student s2 = new Student();
        s2.setName("Olya");
        s2.setSecondName("Kurilenko");
        s2.setMarks(integList2);
        s2.setSubjects(s2S);

        Student s3 = new Student();
        s3.setName("Igor");
        s3.setSecondName("Igorenko");
        s3.setMarks(integList3);
        s3.setSubjects(s3S);

        Student s4 = new Student();
        s4.setName("Grisha");
        s4.setSecondName("Goncharenko");
        s4.setMarks(integList4);
        s4.setSubjects(s4S);

        ArrayList<Student> studList = new ArrayList<>();
        studList.add(s);
        studList.add(s1);
        studList.add(s2);
        studList.add(s3);
        studList.add(s4);

        return studList;
    }

    public Student getStudentByName(String name) {
        Student tmp = getStudents().get(0);
        for (int i = 0; i < getStudents().size(); i++) {
            if (getStudents().get(i).getName().equals(name)) {
                tmp = getStudents().get(i);
            }
        }
        return tmp;
    }

    private Student longestSecondName(ArrayList<Student> students) {
        Student max = students.get(0);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSecondName().length() > max.getSecondName().length()) {
                max = students.get(i);
            }
        }
        return max;
    }

    private Student studentWithMaxSummMarks(ArrayList<Student> students) {
        Student maX = students.get(0);
        int tmp = 0;
        int maxMarks = 0;
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.get(i).getMarks().size(); j++) {
                maxMarks += students.get(i).getMarks().get(j);
                if (maxMarks > tmp) {
                    maX = students.get(i);
                    tmp = maxMarks;
                }
            }
            maxMarks = 0;
        }
        return maX;
    }

    public void writeToFile() {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            for (int i = 0; i < getStudents().size(); i++) {
                out.println(getStudents().get(i).toString());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
