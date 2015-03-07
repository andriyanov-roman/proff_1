
package shop.view;


import shop.Good;
import shop.Validator;
import shop.db_access.DBgood;
import shop.user.Authentification;
import shop.user.SAdding;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
    protected Scanner scanner = new Scanner(System.in);
    public ArrayList<Good> goods = new ArrayList<>();
    public Authentification u = new Authentification();

    public View() {
        doWork();
    }


    public void doWork() {

        System.out.println("1) Add new good" + "\n" +
                /*"2) Make a daily report" + "\n"*/  "2) Add zip" + "\n" + "3) Add supplier" + "\n" + "0) Exit");
        String quest = scanner.next();

        while (quest != null) {
            shop.Good good = new shop.Good();
            Validator v = new Validator();
            if (quest.equals("0")) {
                System.out.println("Closed");
                break;
            } else if (quest.equals("2")) {
                new ZipMaker();
                System.out.println("OK!");
                break;
            } else if (quest.equals("3")) {
                new SAdding();
                question();
                break;
            } else if ("1".equals(quest)) {
                System.out.println("Enter name:");
                String name = scanner.next();
                if (v.isGoodNameValid(name)) {
                    good.setName(name);
                }
                System.out.println("Enter quantity:");
                String quant = scanner.next();
                if (v.isGoodQuantityValid(quant)) {
                    good.setQuantity(Integer.parseInt(quant));
                }
                System.out.println("Enter code:");
                String code = scanner.next();
                if (v.isGoodBarcodeValid(code)) {
                    good.setCode(Long.parseLong(code));
                }
                System.out.println("Enter type:");
                String type = scanner.next();
                if (v.isGoodTypeValid(type)) {
                    good.setType(type);
                }
                goods.add(good);
                DBgood dBgood = new DBgood();
                try {
                    dBgood.executeUpdate(good);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                question();


            }
        }
    }

    public void question() {

        System.out.println("Add smth else?  Y/N ");
        String res = scanner.next();
        if (res.equalsIgnoreCase("Y")) {

            doWork();


        } else if (res.equalsIgnoreCase("N")) {


            try {

                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/home/eugene/proff_repos/proff_1/yevhenii/src/main/java/shop/view/report", true)));
                for (int i = 0; i < goods.size(); i++) {
                    out.println(goods.get(i).toString());
                }

                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("OK!");

        }
    }
}


