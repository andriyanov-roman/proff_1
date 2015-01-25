package kurs.oop;

public class Obekty {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Ivan";
        s1.secondName = "Ivanov";
        s1.marks = new int[]{5, 5, 2};

        Student s2 = new Student();
        s2.name = "Alan";
        s2.secondName = "Tuyngayovich";
        s2.marks = new int[]{5, 5, 5, 5};

        Student s3 = new Student();
        s3.name = "Vova";
        s3.secondName = "Olegovich";
        s3.marks = new int[]{3, 4, 5};

        Student s4 = new Student();
        s4.name = "Vlad";
        s4.secondName = "Ololovich";
        s4.marks = new int[]{4, 4, 4};

        Student s5 = new Student();
        s5.name = "Ololo";
        s5.secondName = "Ovoch";
        s5.marks = new int[]{5, 5, 5};

        Student[] students = new Student[5];
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        students[3] = s4;
        students[4] = s5;


        searchSecondName(students);

    }

    static void searchSecondName(Student[] students) {
        Student s = students[0];
        for (int i = 0; i < students.length; i++) {
            if (students[i].secondName.length() > s.secondName.length()) {
                s = students[i];
            }
        }
        System.out.println(s.secondName);
        searchMarks(students);
    }


    static void searchMarks(Student[] students) {
        Student s = students[0];
        int maxMarks = 0;
        for (int j = 0; j < students.length; j++) {
            for (int i = 0; i < students[i].marks.length; i++) {

            }

        }

    }
}
  


    
