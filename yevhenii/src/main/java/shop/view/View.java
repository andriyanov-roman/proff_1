package shop.view;

import exceptions.Good;
import exceptions.Validator;
import shop.user.Authentification;
import shop.user.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by eugene on 01.02.15.
 */
public class View {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Good> goods = new ArrayList<>();
    Authentification u = new Authentification();
    Date date = new Date();


    public View() {
        doWork();
    }


    public void doWork() {

        System.out.println("1) Add new good" + "\n" +
                "2) Make a daily report" + "\n" + "0) Exit");
        String quest = scanner.next();

        while (quest !=null) {
            Good good = new Good();
            Validator v = new Validator();
            if (quest.equals("0")) {
                System.out.println("Closed");
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

                System.out.println("Add smth else?  Y/N ");
                String res = scanner.next();
                if (res.equalsIgnoreCase("Y")) {
                    doWork();
                } else if (res.equalsIgnoreCase("N")) {
                    for (int i = 0; i < goods.size(); i++) {


                    }
                    try {

                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/home/eugene/proff_repos/proff_1/yevhenii/src/main/java/shop/view/report", true)));
                        for (int i = 0; i < goods.size(); i++) {
                            out.println(goods.get(i).toString());
                        }
                        out.println(date);
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("OK!");
                }
                break;
            }
        }
    }
}
