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
            good.setName(getValidatedName());
            System.out.println("Number of good");
            good.setNumber(Integer.parseInt(getValidatedNumber()));
            System.out.println("Bar of good");
            good.setBarcode(Integer.parseInt(getValidatedBarCode()));
            System.out.println("Type of good");
            good.setType(getValidatedType());
            System.out.println("Write 0 to save file");
            if ("0".equals(scanner.next())) {
                System.out.println("Exit");
                writeToFile(good, "/home/artem/IdeaProjects/zaebatiymagazin");
                System.out.println("Save or continue:yes/no");
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
            name = getValidatedName();
        }
        return name;
    }

    public String getValidatedNumber() {
        String number = scanner.next();
        if (validator.getNumber(number)) {
            return number;
        } else {
            System.out.println("Incorrect number");
            number=getValidatedNumber();
        }
        return number;
    }

    public String getValidatedBarCode() {
        String barCode = scanner.next();
        if (validator.gerBarCode(barCode)) {
            return barCode;
        } else {
            System.out.println("Incorrect Bar Code");
            barCode=getValidatedBarCode();
        }
        return barCode;
    }

    public String getValidatedType() {
        String type = scanner.next();
        if (validator.getType(type)) {
            return type;
        } else {
            System.out.println("Incorrect Type");
            type = getValidatedType();
        }
        return type;
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
