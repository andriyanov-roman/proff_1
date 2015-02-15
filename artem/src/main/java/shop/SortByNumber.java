package shop;

import java.util.Comparator;

/**
 * Created by artem on 07.02.15.
 */
public class SortByNumber implements Comparator<Good> {


    @Override
    public int compare(Good o1, Good o2) {
        if (o1.getNumber() > o2.getNumber()) {
            return 1;
        }
        if (o1.getNumber() <o2.getNumber()) {
            return -1;
        }
        return 0;
    }
}
