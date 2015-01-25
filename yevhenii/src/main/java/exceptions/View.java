package exceptions;

import exceptions.Good;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eugene on 24.01.15.
 */
public class View {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Good> goods = new ArrayList<Good>();

    public View() {
        work();
    }


    public void work() {


        while (scanner.hasNext()) {
            Good good = new Good();
            Validator v = new Validator();
            if ("0".equals(scanner.next())) {
                break;
            } else {
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
                    work();
                } else if (res.equalsIgnoreCase("N")) {
                    for (int i = 0; i < goods.size(); i++) {


                    }
                    try {

                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/home/eugene/leleleka.txt", true)));
                        for (int i = 0; i < goods.size(); i++) {
                            out.println(goods.get(i).toString());
                        }
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



