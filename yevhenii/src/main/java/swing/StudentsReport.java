package swing;



import java.io.*;
import java.util.ArrayList;


public class StudentsReport extends Report {
    private String input = "/home/eugene/leleka";
    private String output = "/home/eugene/reports/outStud";
    ArrayList<StudentHelper> students = new ArrayList<>();

    public Integer getAverage(ArrayList<Integer> marks) {
        Integer result = 0;
        for (int i = 0; i < marks.size(); i++) {
            result = (result + marks.get(i)) / marks.size();
        }
        return result;
    }

    public ArrayList<StudentHelper> sortStud() throws IOException {
        ArrayList<StudentHelper> sortedArr = new ArrayList<>();
        sortedArr.addAll(students);
        StudentHelper temp;
        for (int i = sortedArr.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (getAverage(sortedArr.get(j).marks) < getAverage(sortedArr.get(j + 1).marks)) {
                    temp = sortedArr.get(j);
                    sortedArr.set(j, sortedArr.get(j + 1));
                    sortedArr.set(j + 1, temp);
                }
            }
        }


        return sortedArr;
    }


    @Override
    public void generateReport() throws IOException {
        StudentHelperTwo studentHelper = new StudentHelperTwo();
        studentHelper.getStudents();
        try {

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(output, true)));
            for (int i = 0; i < students.size(); i++) {
                out.println(sortStud().get(i).toString());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OK!");
    }

    private class StudentHelper {
        private String name;
        private String surname;
        private ArrayList<Integer> marks;

        public String toString() {
            return name + ":" + surname + ":" + marks;
        }
    }

    private class StudentHelperTwo {
        private static final int NAME = 0;
        private static final int SURNAME = 1;
        private static final int MARKS = 2;


        private ArrayList<String[]> getStrings() throws IOException {
            ArrayList<String> stringList = new ArrayList<>();
            ArrayList<String[]> strings = new ArrayList<>();

            File file = new File(input);
            FileReader reader = new FileReader(file);
            BufferedReader bfReader = new BufferedReader(reader);
            String line;
            while ((line = bfReader.readLine()) != null) {
                stringList.add(line);
            }
            reader.close();
            for (int i = 0; i < stringList.size(); i++) {
                strings.add(stringList.get(i).split(":"));
            }
            return strings;
        }

        private ArrayList<Integer> getMarks(String str) {
            String[] marks = str.split("\\W");
            ArrayList<Integer> marksList = new ArrayList<>();
            for (int j = 0; j < marks.length; j++) {
                if (!marks[j].isEmpty()) {
                    marksList.add(Integer.parseInt(marks[j]));
                }
            }
            return marksList;
        }

        private void getStudents() throws IOException {

            for (int i = 0; i < getStrings().size(); i++) {

                StudentHelper student = new StudentHelper();
                student.name = (getStrings().get(i)[NAME]);
                student.surname = (getStrings().get(i)[SURNAME]);
                student.marks = (getMarks(getStrings().get(i)[MARKS]));

                students.add(student);


            }

        }

    }
}



