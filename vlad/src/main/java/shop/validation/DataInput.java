package shop.validation;
import shop.goods.GoodUtility;

import java.util.Scanner;

public class DataInput {
    public Scanner scanner = new Scanner(System.in);
    public GoodsValidator validator = new GoodsValidator();
    public UserValidator loginValidator = new UserValidator();

    public String getName() {
        String name = scanner.next();
        if (validator.isGoodNameValid(name)) {
            return name;
        } else {
            System.out.println("Good name is not valid. Type only letters from upper case");
            name = getName();
        }
        return name;
    }

    public String getQuantity() {
        String quantity = scanner.next();
        if (validator.isGoodQuantityValid(quantity)) {
            return quantity;
        } else {
            System.out.println("Good quantity is not valid. Type only numbers");
            quantity = getQuantity();
        }
        return quantity;
    }

    public String getBarcode() {
        String barcode = scanner.next();
        if (validator.isGoodBarcodeValid(barcode)) {
            return barcode;
        } else {
            System.out.println("Good barcode is not valid. Type only numbers");
            barcode = getBarcode();
        }
        return barcode;
    }

    public String getType() {
        String type = scanner.next();
        if (validator.isGoodTypeValid(type)) {
            return type;
        } else {
            System.out.println("Good type is not valid. Type only letters from upper case");
            type = getType();
        }
        return type;
    }

    public void enterLoginAndPassword() {
        String login;
        String password;
        try {
            System.out.println("Enter login: ");
            login = scanner.next();
            System.out.println("Enter password: ");
            password = scanner.next();
            if (loginValidator.isUserCorrect(login, password)) {
                System.out.println("OK");
            }
            else throw new LoginException();
        } catch (LoginException e) {
            System.out.println("Try again!");
            enterLoginAndPassword();
        }

    }
    public void seeSorted(){
        GoodUtility goodUtility = new GoodUtility();
        System.out.println("See sorted by barcode: 1 / See sorted by quantity: 2");

        String answer = scanner.next();
        if(answer.equals("1")){
            goodUtility.getSortedByBarcode();
        }
        if(answer.equals("2")){
            goodUtility.getSortedByQuantity();
        }
    }

}


