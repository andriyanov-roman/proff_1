package university_get_set;

import java.util.ArrayList;

public class UniversityData {
    SysadminData sysadminData = new SysadminData();
    TeacherData teacherData = new TeacherData();
    CleanerData cleanerData = new CleanerData();

    public ArrayList<University> getUniversity() {


        University u = new University();
        u.setName("Nau");
        University u2 = new University();
        u2.setName("KNEU");
        University u3 = new University();
        u3.setName("KPI");
        ArrayList<University> listUnivers = new ArrayList<University>();
        listUnivers.add(u);
        listUnivers.add(u2);
        listUnivers.add(u3);


        return listUnivers;


    }

    public Worker maxWorkerSalary() {
        ArrayList<Worker> listWorkers = new ArrayList<Worker>();
        listWorkers.addAll(sysadminData.getSysadmin());
        listWorkers.addAll(teacherData.getTeacher());
        listWorkers.addAll(cleanerData.getCleaner());
        Worker tempWorker = listWorkers.get(0);
        for (int i = 0; i < listWorkers.size(); i++) {
            if (listWorkers.get(i).getSalary() > tempWorker.getSalary()) {
                tempWorker = listWorkers.get(i);
            }

        }
        return tempWorker;
    }


}
