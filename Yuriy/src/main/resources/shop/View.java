package shop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator();
    private GoodDAOImpl goodDAO = new GoodDAOImpl();
    private PrintAll print = new PrintAll();

    public View() throws IOException, SQLException {
        startProgram();
    }

    public void startProgram() throws IOException, SQLException {
        System.out.println("You already exist user ? PRESS   '1'  / " + "  Create new User PRESS   '2'");
        while (scanner.hasNext()) {
            if ("1".equals(scanner.nextLine())) {
                enterLogin();
            }
            if ("2".equals(scanner.nextLine())) {
                createNewUser();
            }
            if ("0".equals(scanner.nextLine())) {
                System.out.println("Exit");
                System.exit(0);
            }
        }
    }

    public void enterLogin() throws IOException {
        System.out.println("Enter Login ...");
        while (scanner.hasNext()) {
            String intup = scanner.nextLine();
            if (validator.isLoginCorrect(intup)) {
                enterPassword();
            } else {
                enterLogin();
            }
        }
    }

    public void enterPassword() throws IOException {
        System.out.println("Enter Password  ...");
        while (scanner.hasNext()) {
            if (validator.isPasswordCorrect(scanner.nextLine())) {
                try {
                    enterGoods();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                enterPassword();
            }
        }
    }

    public void createNewUser() {

    }

    public void enterGoods() throws SQLException {
        System.out.println("Add new good PRESS '1'   See list of goods PRESS '2' ");
        Good good = new Good();
        while (scanner.hasNext()) {
            if ("1".equals(scanner.nextLine())) {
                System.out.println("Enter name");
                String goodName = scanner.nextLine();
                if (validator.isGoodNameValid(goodName)) {
                    good.setName(goodName);
                }
                System.out.println("Amount of good");
                String goodAmount = scanner.nextLine();
                if (validator.isGoodAmount(goodAmount)) {
                    good.setAmount(Integer.parseInt(goodAmount));
                }
                System.out.println("Barcode");
                String barcode = scanner.nextLine();
                if (validator.isGoodBarcode(barcode)) {
                    good.setBarcode(Long.parseLong(barcode));
                }
                System.out.println("Type");
                String type = scanner.nextLine();
                if (validator.isGoodType(type)) {
                    good.setType(type);
                }
                try {
                    goodDAO.executeUpdate(good);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if ("2".equals(scanner.nextLine())) {
                System.out.println("All goods list:");
                print.PrintGoods();
            }
        }
    }
}
