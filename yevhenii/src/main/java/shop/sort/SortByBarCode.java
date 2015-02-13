package shop.sort;

import shop.Good;

import java.util.Comparator;

/**
 * Created by eugene on 07.02.15.
 */

   public class SortByBarCode implements Comparator<Good> {

        @Override
        public int compare(Good o1, Good o2) {
            if (o1.getCode() < o2.getCode()){
                return 1;
            }if (o1.getCode() > o2.getCode()){
                return -1;

            }else {
                return 0;
            }
        }
    
    }

