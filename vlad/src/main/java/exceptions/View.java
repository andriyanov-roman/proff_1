package exceptions;

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
                String quantity = getQuantity();
                good.setQuantity(Integer.parseInt(quantity));

                System.out.println("Barcode: ");
                String barcode = getBarcode();
                good.setBarcode(Integer.parseInt(barcode));

                System.out.println("Type: ");
                String type = getType();
                good.setType(type);

                System.out.println("Good is valid");
                Writer.writeToFile(good);

                System.out.println("Continue: y/n");
                String answerTwo = scanner.next();

                if (answerTwo.equalsIgnoreCase("y")) {
                    start();
                }
                if (answerTwo.equalsIgnoreCase("n")) {
                    String text = new Scanner(new File("vlad/src/main/java/exceptions/shop")).
                            useDelimiter("\\A").next();
                    System.out.println(text);
                    break;
                }
            }
            if (answer.equals("2")) {
                String text = new Scanner(new File("vlad/src/main/java/exceptions/shop")).
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

    private String getQuantity() {
        String quantity = scanner.next();
        if (validator.isGoodQuantityValid(quantity)) {
            return quantity;
        } else {
            System.out.println("Good quantity is not valid. Type again");
            quantity = getQuantity();
        }
        return quantity;
    }

    private String getBarcode() {
        String barcode = scanner.next();
        if (validator.isGoodBarcodeValid(barcode)) {
            return barcode;
        } else {
            System.out.println("Good barcode is not valid. Type again");
            barcode = getBarcode();
        }
        return barcode;
    }

    private String getType() {
        String type = scanner.next();
        if (validator.isGoodTypeValid(type)) {
            return type;
        } else {
            System.out.println("Good type is not valid. Type again");
            type = getType();
        }
        return type;
    }
}