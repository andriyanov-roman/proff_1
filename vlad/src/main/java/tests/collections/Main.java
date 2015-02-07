package tests.collections;

import shop.goods.Good;
import tests.io.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(12);
        linkedList.add(123);
        linkedList.add(1232);
        System.out.println(linkedList);
        System.out.println(linkedList);
        Map<String, Integer> map = new HashMap<>();
        map.put("Vlad", 1);
        map.put("Zhenya", 2);
        map.put("Arten", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
