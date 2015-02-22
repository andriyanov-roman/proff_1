package university;
import java.util.ArrayList;

public class TeacherData {
    public ArrayList<Teacher> getTeacher() {
        StudentData sd = new StudentData();
        SubjectData subjectData = new SubjectData();

        ArrayList<Student> sForTeach = new ArrayList<>();
        sForTeach.add(sd.getStudentByName("Ivan"));
        sForTeach.add(sd.getStudentByName("Vasya"));
        sForTeach.add(sd.getStudentByName("Olya"));

        ArrayList<Subject> teachSabject = new ArrayList<>();
        teachSabject.add(subjectData.getSubjectByName("Math"));

        Teacher teacher = new Teacher();
        teacher.setName("Fedor");
        teacher.setExperience(6);
        teacher.setSalary(1000);
        teacher.setSubjects(teachSabject);
        teacher.setStudents(sForTeach);
        teacher.setSex("men");

        Teacher teacher1 = new Teacher();
        teacher1.setName("Gregor");
        teacher1.setSalary(1100);
        teacher1.setExperience(1);
        teacher1.setSex("men");

        Teacher teacher2 = new Teacher();
        teacher2.setName("Frog");
        teacher2.setSalary(1200);
        teacher2.setExperience(15);
        teacher2.setSex("women");

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        teachers.add(teacher1);
        teachers.add(teacher2);

        return teachers;
    }
    public Teacher maxTeacher(ArrayList<Teacher> teacher) {
        Teacher tmp = teacher.get(0);
        for (int i = 0; i < teacher.size(); i++) {
            if (tmp.getSalary() < teacher.get(i).getSalary()) {
                tmp = teacher.get(i);
            }
        }
        return tmp;
    }

}


