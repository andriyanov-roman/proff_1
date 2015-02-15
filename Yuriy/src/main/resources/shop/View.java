package shop;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator();


    public View() throws IOException {
        enterLogin();
    }

    public void enterLogin() throws IOException {
        System.out.println("Enter Login ...");
        while (scanner.hasNext()) {
            String intup = scanner.nextLine();
            try {
                if (validator.isLoginCorrect(intup)) {
                    enterPassword();
                }
            } catch (PasswordLoginExcp passwordLoginExcp) {
                passwordLoginExcp.printStackTrace();
            }

        }
    }

    public void enterPassword() throws IOException {
        System.out.println("Enter Password  ...");
        while (scanner.hasNext()) {
            String intut = scanner.nextLine();
            if (validator.isPasswordCorrect(intut)) {
                startProgram();
            }
        }


    }

    public void startProgram() throws IOException {
        System.out.println("Enter new goods PRESS    1   /   " + "      show already add PRESS   2");

        while (scanner.hasNext()) {
            Good goods = new Good();
            HashSet<Good> goodses = new HashSet<>();
            String input = scanner.nextLine();
            User user = new User();

            if ("1".equals(input)) {

                System.out.println("Enter name");
                String goodName = scanner.nextLine();
                if (validator.isGoodNameValid(goodName)) {
                    goods.setName(goodName);
                }
                System.out.println("Amount of good");
                String goodAmount = scanner.nextLine();
                if (validator.isGoodAmount(goodAmount)) {
                    goods.setAmount(Integer.parseInt(goodAmount));
                }
                System.out.println("Barcode");
                String barcode = scanner.nextLine();
                if (validator.isGoodBarcode(barcode)) {
                    goods.setBarcode(Long.parseLong(barcode));
                }
                System.out.println("Type");
                String type = scanner.nextLine();
                if (validator.isGoodType(type)) {
                    goods.setType(type);
                }

                GoodsModel.writeToFile(goods);
            }
            goodses.add(goods);

            if ("0".equals(scanner.nextLine())) {
                System.out.println("Exit");
                break;
            }


        }
    }


}
