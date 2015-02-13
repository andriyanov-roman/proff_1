package shop.main;

import shop.goods.Good;
import shop.goods.GoodUtility;

import java.io.*;
import java.util.Scanner;

public class View {
    shop.validation.DataInput dataInput = new shop.validation.DataInput();
    GoodUtility goodUtility = new GoodUtility();

    public View() throws IOException {
        dataInput.enterLoginAndPassword();
        start();
    }

    public void start() throws IOException {

        System.out.println("Enter new good: 1 / See report: 2 / Make ZIP: 3 /" +
                " Show sorted: 4");

        while (dataInput.scanner.hasNext()) {
            Good good = new Good();
            String answer = dataInput.scanner.next();
            switch (answer) {
                case "0": {
                    System.out.println("Exit");
                    break;
                }
                case "1": {
                    System.out.println("Name: ");
                    good.setName(dataInput.getName());

                    System.out.println("Quantity: ");
                    good.setQuantity(Integer.parseInt(dataInput.getQuantity()));

                    System.out.println("Barcode: ");
                    good.setBarcode(Integer.parseInt(dataInput.getBarcode()));

                    System.out.println("Type: ");
                    good.setType(dataInput.getType());

                    goodUtility.addGood(good);

                    System.out.println("Continue: y/n");
                    String answerTwo = dataInput.scanner.next();

                    if (answerTwo.equalsIgnoreCase("y")) {
                        start();
                    }
                    if (answerTwo.equalsIgnoreCase("n")) {
                        System.out.println("Goodbye!");
                        break;
                    }
                }
                case "2": {
                    goodUtility.printAllGoods();
                    break;
                }
                case "3": {
                    goodUtility.makeZIP();
                    System.out.println("ZIP made");
                    break;
                }
                case "4": {
                    dataInput.seeSorted();
                    break;
                }
            }
        }
    }
}


