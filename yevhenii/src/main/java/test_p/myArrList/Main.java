package test_p.myArrList;

import java.util.ArrayList;

/**
 * Created by eugene on 13.02.15.
 */
public class Main {
    public static void main(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        myArray.add(0, 3);
        myArray.add(1, 4);
        myArray.add(10, 14);
        myArray.remove(14);

        MyArray<String> a = new MyArray<>();
        String s = "lelel";
        a.add(3, "lelel");
        a.add(4,"leke");
        a.remove(s);

        System.out.println(myArray.toString());
        System.out.println(myArray.getLength());
        System.out.println(a.toString());
        System.out.println(a.get(4));
        System.out.println(a.get("leke"));
    }
}
