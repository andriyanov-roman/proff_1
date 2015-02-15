package shop;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by artem on 07.02.15.
 */
public class SortByBarCode implements Comparator<Good> {




    @Override
    public int compare(Good o1, Good o2) {
        if (o1.getBarcode() > o2.getBarcode()) {
            return 1;
        }
        if (o1.getBarcode() <o2.getBarcode()) {
            return -1;
        }
        return 0;
    }
}
