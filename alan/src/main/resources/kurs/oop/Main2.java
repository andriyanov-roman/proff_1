package kurs.oop;


import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("test");
        list.add(new Student());
        list.add(1);
        String test = (String) list.get(0);
//        String test2 = (String) list.get(1);
        if (list.get(1) instanceof String) {
            String test1 = (String) list.get(1);
        }
   //     System.out.println(test2);

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("test");
        list2.add("test2");
        list2.add("test3");

 //       System.out.println(list2.toString());
  //      ArrayList<String> list2 = new ArrayList <> ();
        ArrayList <String> list3 = new ArrayList <String> ();
        list3.add("T-100");
        list3.addAll(list2);
        list3.add(1, "Vlad");
        list3.add(1,"Alan");
        list3.ensureCapacity(5);
        list3.indexOf("Vlad");
        System.out.println(list3.toString());
        System.out.println(list3.toString());
        System.out.println(list3.contains("Vlad"));
        System.out.println(list3.toString());

    }




}
