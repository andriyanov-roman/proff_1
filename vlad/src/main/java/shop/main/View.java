package shop.main;

import shop.db_access.GoodDAO;
import shop.goods.Good;
import shop.goods.GoodUtility;
import shop.supplier.Supplier;
import shop.supplier.SupplierUtility;

import java.io.*;


public class View {
    private shop.validation.DataInput dataInput = new shop.validation.DataInput();
    private GoodUtility goodUtility = new GoodUtility();
    private SupplierUtility supplierUtility = new SupplierUtility();

    public View() throws IOException {
        dataInput.enterLoginAndPassword();
        start();
    }

    public void start() throws IOException {
        System.out.println("Enter new good: 1 / Enter new supplier: 2 / See report: 3 / Make ZIP: 4 /" +
                " Show sorted: 5");

        while (dataInput.scanner.hasNext()) {
            Good good = new Good();
            String answer = dataInput.scanner.next();
            switch (answer) {
                case "0": {
                    System.out.println("Exit");
                    break;
                }
                case "1":
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
                    }
                    break;

                case "2":
                    Supplier supplier = new Supplier();
                    System.out.println("Supplier name: ");
                    supplier.setName(dataInput.getSuppName());

                    System.out.println("Supplier good type: ");
                    supplier.setGoodType(dataInput.getGoodType());

                    System.out.println("Good ID: ");
                    supplier.setGoodID(Integer.parseInt(dataInput.getGoodID()));

                    supplierUtility.addSupplier(supplier);
                    System.out.println("Continue: y/n");

                    String answerThree = dataInput.scanner.next();

                    if (answerThree.equalsIgnoreCase("y")) {
                        start();
                    }
                    if (answerThree.equalsIgnoreCase("n")) {
                        System.out.println("Goodbye!");
                    }
                    break;


                case "3":
                    goodUtility.printAllGoods();
                    break;

                case "4":
                    goodUtility.makeZIP();
                    System.out.println("ZIP made");
                    break;

                case "5":
                    dataInput.seeSorted();
                    break;
            }
            break;
        }
    }
}



