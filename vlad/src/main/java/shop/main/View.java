package shop.main;

import shop.users.User;
import shop.validation.Good;

import java.io.*;
import java.util.Scanner;

public class View {
    shop.validation.DataInput dataInput = new shop.validation.DataInput();

    public View() throws IOException {
        start();
    }

    public void start() throws IOException {
        dataInput.enterLoginAndPassword();
        System.out.println("Enter new good: 1 / See report: 2");

        while (dataInput.scanner.hasNext()) {
            Good good = new Good();
            String answer = dataInput.scanner.next();
            if (answer.equals("0")) {
                System.out.println("Exit");
                break;
            }
            if (answer.equals("1")) {
                System.out.println("Name: ");
                good.setName(dataInput.getName());

                System.out.println("Quantity: ");
                good.setQuantity(Integer.parseInt(dataInput.getQuantity()));

                System.out.println("Barcode: ");
                good.setBarcode(Integer.parseInt(dataInput.getBarcode()));

                System.out.println("Type: ");
                good.setType(dataInput.getType());

                System.out.println("Good is valid");
                shop.writer.Writer.writeToFile(good, "/home/vladislav/proff_repos/proff_1/vlad/src/main/java/exceptions/shop");

                System.out.println("Continue: y/n");
                String answerTwo = dataInput.scanner.next();

                if (answerTwo.equalsIgnoreCase("y")) {
                    start();
                }
                if (answerTwo.equalsIgnoreCase("n")) {
                    String text = new Scanner(new File("/vlad/src/main/java/files")).
                            useDelimiter("\\A").next();
                    System.out.println(text);
                    break;
                }
            }
            if (answer.equals("2")) {
                String text = new Scanner(new File("/vlad/src/main/java/files")).
                        useDelimiter("\\A").next();
                System.out.println(text);
                break;
            }
        }
    }
}


