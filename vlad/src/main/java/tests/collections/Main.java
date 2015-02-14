package tests.collections;

import shop.goods.Good;
import tests.io.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Lele");
        myArrayList.add("Lele1");
        myArrayList.add("Lele2");
        myArrayList.add("Lele5");
        myArrayList.add("Lele");
        myArrayList.add("Lele1");
        myArrayList.add("Lele2");
        myArrayList.add("Lele5");
        myArrayList.add("Lele");
        myArrayList.add("Lele1");
        myArrayList.add("Lele2");
        myArrayList.add("Lele5");
        myArrayList.add("Lele");

        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(2));

        System.out.println(myArrayList.size());
        myArrayList.remove("Lele");
        System.out.println(myArrayList.size());

        for(int i = 0; i < myArrayList.size(); i++){
            System.out.println(myArrayList.get(i));
            if(myArrayList.get(i) == myArrayList.get("Lele")){
                System.out.println("!!");
            }
        }
    }
}
