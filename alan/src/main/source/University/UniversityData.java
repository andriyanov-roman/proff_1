/*package University;
public class UniversityData {
    public University [] getUniversity (){
        SubjectData sd = new SubjectData();
        Subject [] subjects = sd.getSubjects();
        StudentData studentData = new StudentData();
        Student[] students = studentData.getStudents();

        University univerName = new University();
        univerName.listStudents = new Student[] {studentData.getStudentsByName("Vova")};
        univerName.listSubjects = new Subject[] {sd.getSubjectsName("Asd"), sd.getSubjectsName("Pppi")};
        univerName.univerName = "NAU";

        University univerNameOne = new University();
        univerNameOne.listStudents = new Student[] {studentData.getStudentsByName("Alan")};
        univerNameOne.listSubjects = new Subject[] {sd.getSubjectsName("Vpi")};
        univerNameOne.univerName = "KPI";

        University univerNameTwo = new University();
        univerNameTwo.listStudents = new Student[] {studentData.getStudentsByName("Ivan")};
        univerNameTwo.listSubjects = new Subject[] {sd.getSubjectsName("Asd")};
        univerNameTwo.univerName = "KNEU";

        University [] arrayUniversitys = new University[3];
        arrayUniversitys [0] = univerName;
        arrayUniversitys [1] = univerNameOne;
        arrayUniversitys [2] = univerNameTwo;
        return new University[] {univerName, univerNameOne, univerNameTwo};
    }

}
*/