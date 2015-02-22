package report;

import university.Student;

import java.io.*;
import java.util.ArrayList;

public class StudentReport extends Report {
    private ArrayList<StudentHelper> students = new ArrayList<>();

    @Override
    public void genereteReport() throws IOException {
        StudentHelper helper = new StudentHelper();
        helper.getStudents();
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1; j++) {
                if (getAverage(students.get(j).marks) > getAverage(students.get(j + 1).marks)) {
                    StudentHelper tmp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, tmp);
                }
            }
        }
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src\\StudentReport.txt")));
            for (int i = 0; i < students.size(); i++) {
                out.println(students.get(i).name + " " + students.get(i).secondName + " " + getAverage(students.get(i).marks));
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer getAverage(ArrayList<Integer> marks) {
        Integer result = 0;
        for (int i = 0; i < marks.size(); i++) {
            result += marks.get(i);
        }
        return result / marks.size();
    }
    private ArrayList<Integer> getMarks(String str) {
        String[] marks = str.split("\\W");
        ArrayList<Integer> marksList = new ArrayList<>();
        for (int i = 0; i < marks.length; i++) {
            if (!marks[i].isEmpty()) {
                marksList.add(Integer.parseInt(marks[i]));
            }
        }
        return marksList;
    }

    private class StudentHelper {
        private String name;
        private ArrayList<Integer> marks;
        private String secondName;

        public void getStudents() throws IOException {
            ArrayList<String[]> strings = getString("src//Students.txt");

            for (int i = 0; i < strings.size(); i++) {
              StudentHelper helper = new StudentHelper();
                helper.name = strings.get(i)[0];
                helper.secondName = strings.get(i)[1];
                helper.marks = getMarks(strings.get(i)[2]);
                students.add(helper);
            }
        }

        public String toString() {
            return name + ":" + secondName + ":" + marks;
        }
    }

    private class StudentHelper2{
        private static final int NAME = 0;
        private static final int SECOND_NAME = 1;
        private static final int MARKS = 2;

        public void getStudents() throws IOException {
            ArrayList<String[]> strings = getString("src//Students.txt");

            for (int i = 0; i < strings.size(); i++) {
                StudentHelper helper = new StudentHelper();
                helper.name = strings.get(i)[NAME];
                helper.secondName = strings.get(i)[SECOND_NAME];
                helper.marks = getMarks(strings.get(i)[MARKS]);
                students.add(helper);
            }
        }
    }

}
