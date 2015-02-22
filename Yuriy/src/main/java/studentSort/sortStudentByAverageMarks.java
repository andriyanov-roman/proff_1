package studentSort;

import university.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class sortStudentByAverageMarks implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (getAverage(o1.getMarks()) < getAverage(o2.getMarks())) {
            return 1;
        }
        if (getAverage(o1.getMarks()) > getAverage(o2.getMarks())){
            return -1;
        }
        return 0;
    }

    private Integer getAverage(ArrayList<Integer> marks) {
        Integer result = 0;
        for (int i = 0; i < marks.size(); i++) {
            result += marks.get(i);
        }
        return result / marks.size();
    }

}
