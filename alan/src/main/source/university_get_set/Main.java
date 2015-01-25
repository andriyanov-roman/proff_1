package university_get_set;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TeacherData teacherData = new TeacherData();
        SysadminData sysadminData = new SysadminData();
        CleanerData cleanerData = new CleanerData();
        UniversityData universityData = new UniversityData();
        System.out.println(universityData.maxWorkerSalary().getName());

        Teacher maxTh = maxSalaryOfTeacher(teacherData.getTeacher());
        Cleaner macCleaner = maxSalaryOfCleaner(cleanerData.getCleaner());
        Sysadmin sysadmin = maxSalaryOfSysadmin(sysadminData.getSysadmin());

        ArrayList<Worker> workerArrayList = new ArrayList<Worker>();
        workerArrayList.addAll(teacherData.getTeacher());
        workerArrayList.addAll(sysadminData.getSysadmin());
        workerArrayList.addAll(cleanerData.getCleaner());
        String parametr = "woman";
        //deleteWomanWorkers(workerArrayList, parametr);

    }
   // public static void deleteWomanWorkers (ArrayList<Worker>)
    public static Teacher maxSalaryOfTeacher (ArrayList<Teacher> thc){
        Teacher tmpTeacher = thc.get(0);
        for (int i = 0; i < thc.size() ; i++) {
            if (thc.get(i).getSalary() > tmpTeacher.getSalary()){
                tmpTeacher = thc.get(i);
            }
        }
        return tmpTeacher;
    }
    public static Cleaner maxSalaryOfCleaner (ArrayList<Cleaner> cln){
        Cleaner tmpCleaner = cln.get(0);
        for (int i = 0; i <cln.size() ; i++) {
            if (cln.get(i).getSalary() > tmpCleaner.getSalary()){
                tmpCleaner = cln.get(i);

            }

        }
        return tmpCleaner;
    }
    public  static Sysadmin maxSalaryOfSysadmin (ArrayList<Sysadmin> sys){
        Sysadmin tmpSysadmin = sys.get(0);
        for (int i = 0; i < sys.size() ; i++) {
            if (sys.get(i).getSalary() > tmpSysadmin.getSalary()){
                tmpSysadmin = sys.get(i);


            }

        }
        return tmpSysadmin;


    }





    }


