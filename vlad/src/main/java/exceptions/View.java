package exceptions;

/**
 * Created by root on 25.01.15.
 */

import java.io.*;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();

    public View() throws IOException {
        start();
    }

    public void start() throws IOException {
        System.out.println("Enter new good: 1 / See report: 2");

        while (scanner.hasNext()) {
            Good good = new Good();
            String answer = scanner.next();
            if (answer.equals("0")) {
                System.out.println("Exit");
                break;
            }
            if (answer.equals("1")) {
                System.out.println("Name: ");
                String name = getName();
                good.setName(name);
                System.out.println("Quantity: ");
                String quantity = scanner.next();
                if (validator.isGoodQuantityValid(quantity)) {
                    good.setQuantity(Integer.parseInt(quantity));
                } else {
                    System.out.println("not valid");
                    break;
                }
                System.out.println("Barcode: ");
                String barcode = scanner.next();
                if (validator.isGoodBarcodeValid(barcode)) {
                    good.setBarcode(Integer.parseInt(barcode));
                } else {
                    System.out.println("not valid");
                    break;
                }
                System.out.println("Type: ");
                String type = scanner.next();
                if (validator.isGoodTypeValid(type)) {
                    good.setType(type);
                    ;
                } else {
                    System.out.println("goods not valid");
                    break;
                }
                System.out.println("Good is valid");
                Writer.writeToFile(good);
                System.out.println("Продолжить: y/n");
                String answerTwo = scanner.next();
                if (answerTwo.equalsIgnoreCase("y")) {
                    start();
                }
                if (answerTwo.equalsIgnoreCase("n")) {
                    String text = new Scanner(new File("/home/vladislav/Документы/goods")).
                            useDelimiter("\\A").next();
                    System.out.println(text);
                    break;
                }
            }
            if (answer.equals("2")) {
                String text = new Scanner(new File("/home/vladislav/Документы/goods")).
                        useDelimiter("\\A").next();
                System.out.println(text);
                break;
            }
        }
    }

    private String getName() {
        String name = scanner.next();
        if (validator.isGoodNameValid(name)) {
            return name;
        } else {
            System.out.println("Good name is not valid. Type again");
            name = getName();
        }
        return name;
    }
}