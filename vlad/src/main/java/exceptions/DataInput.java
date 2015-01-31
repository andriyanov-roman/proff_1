package exceptions;

import java.util.Scanner;

public class DataInput {
    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();
    LoginValidator loginValidator = new LoginValidator();

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

    public String enterLogin() {
        String login;
        try {
            login = scanner.next();
            if (loginValidator.isLoginCorrect(login)) {
                return login;
            } else throw new LoginException();
        } catch (LoginException e) {
            System.out.println("Try again! Type only letters from upper case");
            login = enterLogin();
        }
        return login;
    }

    public String enterPassword() {
        String password = scanner.next();
        return password;
    }
}


