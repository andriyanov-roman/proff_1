package University;/*package University;

/**
 * Created by Алан on 15.11.14.
 */
/*public class Cleanman {
    public static class Main {
        static int tmp = 0;
        static int tmpOne = 0;

        public static void main(String[] args) {
            SubjectData sd = new SubjectData();
            System.out.println(sd.getSubjectsName("math").name);


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


            Student s1 = new Student();
            s1.name = "Ivan";
            s1.secondName = "Ivanov";
            s1.marks = new int[]{5, 5, 2};
            s1.subjects = new Subject[]{math};


            Student s2 = new Student();
            s2.name = "Alan";
            s2.secondName = "Tuyngayovich";
            s2.marks = new int[]{5, 5, 5, 5};
            s2.subjects = new Subject[]{oop};


            Student s3 = new Student();
            s3.name = "Vova";
            s3.secondName = "Olegovich";
            s3.marks = new int[]{3, 4, 5};
            s3.subjects = new Subject[]{vpi};


            Student s4 = new Student();
            s4.name = "Vlad";
            s4.secondName = "Ololovich";
            s4.marks = new int[]{4, 4, 4};
            s4.subjects = new Subject[]{pppi};


            Student s5 = new Student();
            s5.name = "Ololo";
            s5.secondName = "Ovoch";
            s5.marks = new int[]{5, 5, 5};
            s5.subjects = new Subject[]{asd};


            University univerName = new University();
            univerName.listStudents = new Student[] {s1};
            univerName.listSubjects = new Subject[] {vpi};
            univerName.univerName = "NAU";

            University univerNameOne = new University();
            univerNameOne.listStudents = new Student[] {s1, s2, s3,s4,s5};
            univerNameOne.listSubjects = new Subject[] {pppi};
            univerNameOne.univerName = "KPI";

            University univerNameTwo = new University();
            univerNameTwo.listStudents = new Student[] {s1, s2, s3,s4,s5};
            univerNameTwo.listSubjects = new Subject[] {asd};
            univerNameTwo.univerName = "KNEU";

            University [] arrayUniversitys = new University[3];
            arrayUniversitys [0] = univerName;
            arrayUniversitys [1] = univerNameOne;
            arrayUniversitys [2] = univerNameTwo;

            Student[] students = new Student[5];
            students[0] = s1;
            students[1] = s2;
            students[2] = s3;
            students[3] = s4;
            students[4] = s5;

            searchBestStudentsOfUniversity(arrayUniversitys);
            System.out.println(searchBestStudentsOfUniversity(arrayUniversitys).univerName);
        }

        public static University searchBestStudentsOfUniversity(University[] arrayUniversitys) {
            University max = arrayUniversitys[0];
            int bestMarks = 0;
            for (int i = 0; i < arrayUniversitys.length ; i++) {
                for (int j = 0; j < arrayUniversitys[i].listStudents.length ; j++) {
                    for (int k = 0; k < arrayUniversitys[i].listStudents[j].marks.length ; k++) {
                        bestMarks += arrayUniversitys[i].listStudents[j].marks[k];
                        if(bestMarks > tmp) {
                            max = arrayUniversitys[i];
                            tmpOne = bestMarks;
                        }

                    }

                }

            }


            return max;
        }
    }
}
*/