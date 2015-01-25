package exeption;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;


public class View {
    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator();

    public View() {
        startProgram();
    }


    private void startProgram() {
        System.out.println("Enter goods" + "\n" + "Name of good");
        while (scanner.hasNext()) {
            Good good = new Good();
            if(!(getValidatedName().equals("false"))){
                good.setName(getValidatedName());
            }
            System.out.println("Number of good");
            good.setNumber(getValidatedNumber());
            System.out.println("Bar of good");
            good.setBarcode(getValidatedBarCode());
            System.out.println("Type of good");
            good.setType(getValidatedType());
            if ("0".equals(scanner.next())) {
                System.out.println("Exit");
                writeToFile(good, "/home/artem/IdeaProjects/zaebatiymagazin");
                System.out.println("Save or continue");
                String answer = scanner.next();
                if (answer.equals("yes")) {
                    startProgram();
                } else {
                    break;
                }
            }
        }
    }

    public String getValidatedName() {
        String name = scanner.next();
        if (validator.getName(name)) {
            return name;
        } else {
            System.out.println("Incorrect name");
            getValidatedName();
        }
      return "false";
    }

    public BigDecimal getValidatedNumber() {
        String number = scanner.next();
        if (validator.getNumber(number)) {
            return new BigDecimal(number);
        } else {
            System.out.println("Incorrect number");
            getValidatedNumber();
        }
        return null;
    }

    public BigDecimal getValidatedBarCode() {
        String barCode = scanner.next();
        if (validator.gerBarCode(barCode)) {
            return new BigDecimal(barCode);
        } else {
            System.out.println("Incorrect Bar Code");
            getValidatedBarCode();
        }
        return null;
    }

    public String getValidatedType() {
        String type = scanner.next();
        if (validator.getType(type)) {
            return type;
        } else {
            System.out.println("Incorrect Type");
            getValidatedType();
        }
        return null;
    }
    public void writeToFile(Object anyObject, String path) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            out.println(anyObject.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
