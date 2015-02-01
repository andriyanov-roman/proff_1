package shop;

import java.io.*;
import java.util.Scanner;


public class View {
    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator();
    private ControlUser controlUser = new ControlUser();

    public View() throws IOException {
        userControl();
    }

    private void userControl() throws IOException {
        System.out.println("Enter Login and password");
        while (scanner.hasNext()) {
            try {
                if (controlUser.checkUser(scanner.next(), scanner.next())) {
                    startProgram();
                }
            } catch (MyException e) {
                System.out.println(e);
                userControl();
            }
        }
    }

    private void startProgram() {
        System.out.println("Enter goods " + "Name of good");
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
                System.out.println("See report or continue:1/2");
                String answer = scanner.next();
                if ("2".equals(answer)) {
                    startProgram();
                }
                if ("1".equals(answer)) {
                    try {
                        String text = new Scanner(new File("/home/artem/IdeaProjects/zaebatiymagazin")).useDelimiter("\\A").next();
                        System.out.println(text);
                    } catch (FileNotFoundException e) {
                        System.out.println("Incorrect directory");
                    }
                    break;
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
            number = getValidatedNumber();
        }
        return number;
    }

    public String getValidatedBarCode() {
        String barCode = scanner.next();
        if (validator.gerBarCode(barCode)) {
            return barCode;
        } else {
            System.out.println("Incorrect Bar Code");
            barCode = getValidatedBarCode();
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
