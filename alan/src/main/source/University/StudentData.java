/*package University;
public class StudentData {
    class Overage {
        public Student student;
        public float mark = 0;
    }
    public Student[] getStudents() {
        SubjectData sd = new SubjectData();
        Subject[] subjects = sd.getSubjects();

        StudentData studentData = new StudentData();
        Student [] students = studentData.getStudents();

        Student s1 = new Student();
        s1.name = "Ivan";
        s1.secondName = "Ivanov";
        s1.marks = new int[]{5, 5, 2};
        s1.subjects = new Subject[]{sd.getSubjectsName("Math"),sd.getSubjectsName("Asd")};


        Student s2 = new Student();
        s2.name = "Alan";
        s2.secondName = "Tuyngayovich";
        s2.marks = new int[]{5, 5, 5};
        s2.subjects = new Subject[]{sd.getSubjectsName("Pppi"), sd.getSubjectsName("Oop")};


        Student s3 = new Student();
        s3.name = "Vova";
        s3.secondName = "Olegovich";
        s3.marks = new int[]{3, 4, 5};
        s3.subjects = new Subject[]{sd.getSubjectsName("Vpi")};


        Student s4 = new Student();
        s4.name = "Vlad";
        s4.secondName = "Ololovich";
        s4.marks = new int[]{4, 4, 4};
        s4.subjects = new Subject[]{sd.getSubjectsName("Asd")};


        Student s5 = new Student();
        s5.name = "Ololo";
        s5.secondName = "Ovoch";
        s5.marks = new int[]{5, 4, 5};
        s5.subjects = new Subject[]{sd.getSubjectsName("Vpi")};
        return new Student[] {s1, s2, s3, s4, s5};
    }

    public Student getStudentsByName(String name){
        for (int i = 0; i < getStudents().length ; i++) {
            if (getStudents()[i].name.equals(i));
            return getStudents()[i];
        }
        return null;
    }
    public Student getStudentsByBest (Student [] name){
        Overage temp [] = new Overage[name.length];
        for (int i = 0; i < name.length; i++) {
            temp[i]= new Overage();
            temp[i].student = name [i];
            float tempOne = 0;
            for (int j = 0; j <temp[i].student.marks.length ; j++) {
               tempOne +=  temp[i].student.marks [j];

            }
            tempOne /= temp[i].student.marks.length;
            temp[i].mark = tempOne;
        }
        Student tempStudent = null;
        float tempTwo = 0;
        for (int i = 0; i < temp.length ; i++) {
            if(tempTwo < temp[i].mark) {
                tempTwo = temp[i].mark;
                tempStudent = temp[i].student;

            }

        }

        return tempStudent;
    }


}
*/