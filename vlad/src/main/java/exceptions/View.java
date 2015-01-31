package exceptions;

import java.io.*;
import java.util.Scanner;

public class View {
    DataInput dataInput = new DataInput();
    public View() throws IOException {
        start();
    }

    public void start() throws IOException {
        System.out.println("Enter login:");
        while (dataInput.scanner.hasNext()) {
            User user = new User();
            user.setLogin(dataInput.enterLogin());

            System.out.println("Enter password:");
            user.setPassword(dataInput.enterPassword());
            System.out.println("OK");

            System.out.println("Enter new good: 1 / See report: 2");
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
                Writer.writeToFile(good);

                System.out.println("Continue: y/n");
                String answerTwo = dataInput.scanner.next();

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
}


