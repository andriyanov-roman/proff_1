package test_p.myArrList;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by eugene on 13.02.15.
 */
public class MyArray<T> {

    public static final int STARTCAP = 5;
    public Object[] arr = new Object[STARTCAP];


    private int arrCap() {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    public void recrArr(int index) {
        int nlength = STARTCAP + index;
        arr = Arrays.copyOf(arr, nlength);
    }

    private boolean isEnough(int index) {
        boolean verify = false;
        if (index <= arr.length) {
            verify = true;
        } else if (index >= arr.length) {
            verify = false;
        }
        return verify;
    }

    /*void add(T obj) {

       if (isEnough()) {
           arr[arrCap()] = obj;
       }
   }*/
    public void add(int index, T obj) {

        if (isEnough(index)) {
            arr[index] = obj;
        } else if (!isEnough(index)) {
            recrArr(index);
            arr[index] = obj;
        }

    }

    public int getLength() {

        return arr.length;
    }

    public void remove(int index) {
        if (arr[index] != null) {
            arr[index] = null;
        }
    }

    public void remove(Object o) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].equals(o)) {
                    arr[i] = null;
                }
            }
        }
    }
    public Object get(int index){

        return arr[index];
    }
    public Object get(Object o) {
        Object s = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].equals(o)) {
                    s = arr[i];
                }
            }
        }
        return s;
    }


    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
