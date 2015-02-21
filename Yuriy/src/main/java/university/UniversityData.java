package university;

import java.util.ArrayList;

public class UniversityData {
    SisAdminData sisAdminData = new SisAdminData();
    TeacherData teacherData = new TeacherData();
    CleanManagerData cleanManagerData = new CleanManagerData();

    public ArrayList<University> getUniversitys() {
        SubjectData sd = new SubjectData();

        ArrayList<Subject> subjForUniShevchennko = new ArrayList<>();
        subjForUniShevchennko.add(sd.getSubjectByName("Math"));

        ArrayList<Subject> subjForNau = new ArrayList<>();
        subjForNau.add(sd.getSubjectByName("Phizra"));

        ArrayList<Subject> subjForMadicine = new ArrayList<>();
        subjForMadicine.add(sd.getSubjectByName("Himi"));

        StudentData studDat = new StudentData();

        ArrayList<Student> studForUniShevchenko = new ArrayList<>();
        studForUniShevchenko.add(studDat.getStudentByName("Olya"));
        studForUniShevchenko.add(studDat.getStudentByName("Ivan"));

        ArrayList<Student> studForNau = new ArrayList<>();
        studForNau.add(studDat.getStudentByName("Vasya"));

        ArrayList<Student> studForMedicine = new ArrayList<>();
        studForMedicine.add(studDat.getStudentByName("Grisha"));

        University shevcenko = new University();
        shevcenko.setName("Sevchenko");
        shevcenko.setStudentslist(studForUniShevchenko);
        shevcenko.setSubjectlist(subjForUniShevchennko);

        University nau = new University();
        nau.setName("NAU");
        nau.setStudentslist(studForNau);
        nau.setSubjectlist(subjForNau);

        University medicine = new University();
        medicine.setName("Medicine");
        medicine.setStudentslist(studForMedicine);
        medicine.setSubjectlist(subjForMadicine);

        ArrayList<University> listUnivers = new ArrayList<>();
        listUnivers.add(shevcenko);
        listUnivers.add(nau);
        listUnivers.add(medicine);

        return listUnivers;
    }
    public ArrayList<Worker> getWorkers (){
        ArrayList<Worker> workers = new ArrayList<>();
        workers.addAll(sisAdminData.getSis());
        workers.addAll(teacherData.getTeacher());
        workers.addAll(cleanManagerData.getClean());
     return workers;
    }

    public Worker workerMaxSalary() {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.addAll(sisAdminData.getSis());
        workers.addAll(teacherData.getTeacher());
        workers.addAll(cleanManagerData.getClean());
        Worker tmp = workers.get(0);

        for (int i = 0; i < workers.size(); i++) {
            if (tmp.getSalary() < workers.get(i).getSalary()) {
                tmp = workers.get(i);
            }
        }
        return tmp;
    }

    public Student bestStudentFromMarks() {
        Student tmp = getUniversitys().get(0).getStudentslist().get(0);
        int max = 0;
        int maxVr = 0;
        for (int i = 0; i < getUniversitys().size(); i++) {
            for (int j = 0; j < getUniversitys().get(i).getStudentslist().size(); j++) {
                for (int k = 0; k < getUniversitys().get(i).getStudentslist().get(j).getMarks().size(); k++) {
                    max += getUniversitys().get(i).getStudentslist().get(j).getMarks().get(k);
                }
                if (max > maxVr) {
                    tmp = getUniversitys().get(i).getStudentslist().get(j);
                    maxVr = max;
                }
                max = 0;
            }
        }
        return tmp;
    }

    public Student studentFromDiapason(int first, int second) {
        Student tmp = getUniversitys().get(0).getStudentslist().get(0);
        int max = 0;
        for (int i = 0; i < getUniversitys().size(); i++) {
            for (int j = 0; j < getUniversitys().get(i).getStudentslist().size(); j++) {
                for (int k = 0; k < getUniversitys().get(i).getStudentslist().get(j).getMarks().size(); k++) {
                    max += getUniversitys().get(i).getStudentslist().get(j).getMarks().get(k);
                }
                if (max > first && max < second) {
                    tmp = getUniversitys().get(i).getStudentslist().get(j);
                }
                max = 0;
            }
        }
        return tmp;
    }

    private University bestUniversity(ArrayList<University> universities) {
        University max = universities.get(0);
        int tmp2 = 0;
        int maxMarks = 0;
        for (int i = 0; i < universities.size(); i++) {
            for (int j = 0; j < universities.get(i).getStudentslist().size(); j++) {
                for (int k = 0; k < universities.get(i).getStudentslist().get(j).getMarks().size(); k++) {
                    maxMarks += universities.get(i).getStudentslist().get(j).getMarks().get(k);
                    if (maxMarks > tmp2) {
                        max = universities.get(i);
                        tmp2 = maxMarks;
                    }
                }
                maxMarks = 0;
            }
        }
        return max;
    }


}