package shop.main;

import shop.db_access.GoodDAO;
import shop.goods.Good;

import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new HashSet<Good>(new GoodDAO().selectAll()).size());
        new View();
    }
}
