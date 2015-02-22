package shop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator();
    private GoodDAOImpl goodDAO = new GoodDAOImpl();
    private UserDAOImpl userDAO = new UserDAOImpl();
    private SupplierDAOImpl supplierDAO = new SupplierDAOImpl();

    public View() throws IOException, SQLException, ClassNotFoundException {
        startProgram();
    }

    public void startProgram() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("You already exist user ? PRESS   '1'  / " + "  Create new User PRESS   '2'");
        while (scanner.hasNext()) {
            if ("1".equals(scanner.nextLine())) {
                enterLoginAndPassword();
            }
            if ("2".equals(scanner.nextLine())) {
                createNewUser();
            }
            if ("0".equals(scanner.nextLine())) {
                System.exit(0);
                System.out.println("Exit");
            }
        }
    }

    public void enterLoginAndPassword() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("Enter Login ...");
        User u = new User();
        while (scanner.hasNext()) {
            String login = scanner.next();
            u.setLogin(login);
            System.out.println("Enter Password ...");
            String password = scanner.next();
            u.setPasword(password);
            if (validator.isLoginAndPasswordCorrect(u)) {
                enterGoods();
            } else {
                enterLoginAndPassword();
            }
        }
    }

    public void createNewUser() throws SQLException, ClassNotFoundException, IOException {
        System.out.println("Enter User login");
        User user = new User();
        while (scanner.hasNext()) {
            String login = scanner.next();
            user.setLogin(login);
            System.out.println("Enter User password");
            String password = scanner.next();
            user.setPasword(password);
            if (validator.isUserAllrExist(user)) {
                System.out.println(" This User already exist");
                startProgram();
            } else {
                userDAO.executeUpdate(user);
                System.out.println("New User successfully added !!! ");
                enterGoods();
            }
        }
    }


    public void enterGoods() throws SQLException, ClassNotFoundException {
        System.out.println("Add new good PRESS '1'   See list of goods PRESS '2'  Add new supplier PRESS '3'  See list of suppliers PRESS '4'");
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
                if (validator.isGoodAmountValid(goodAmount)) {
                    good.setAmount(Integer.parseInt(goodAmount));
                }
                System.out.println("Barcode");
                String barcode = scanner.nextLine();
                if (validator.isGoodBarcodeValid(barcode)) {
                    good.setBarcode(Long.parseLong(barcode));
                }
                System.out.println("Type");
                String type = scanner.nextLine();
                if (validator.isGoodTypeValid(type)) {
                    good.setType(type);
                }
                if (validator.isGoodAllrExist(good)) {
                    System.out.println("This good already exist in goods list ");
                    enterGoods();
                } else {
                    goodDAO.executeUpdate(good);
                    System.out.println("Good added successfully !!!");
                    enterGoods();
                }
            }
            if ("2".equals(scanner.nextLine())) {
                System.out.println("All goods list:");
                printGoods();
                enterGoods();
            }

            if ("3".equals(scanner.nextLine())) {
                createNewSupplier();
            }
            if ("4".equals(scanner.nextLine())) {
                seeAllSupplier();
            }
            if ("0".equals(scanner.nextLine())) {
                System.exit(0);
                System.out.println("Exit");
            }
        }
    }


    public void printGoods() throws SQLException {
        Set<Good> goodSet = goodDAO.selectGood();
        System.out.println(goodSet.toString());
    }

    public void createNewSupplier() throws SQLException, ClassNotFoundException {
        System.out.println("Enter Supplier name ");
        Supplier supplier = new Supplier();
        while (scanner.hasNext()) {
            String name = scanner.next();
            supplier.setName(name);
            System.out.println("Enter goods type");
            String type = scanner.next();
            supplier.setType(type);

            if (validator.isSupplierAllrExist(supplier)) {
                System.out.println("This supplier already exist");
                createNewSupplier();
            } else {
                supplierDAO.executeUpdate(supplier);
                System.out.println("New supplier successfully added !!! ");
                enterGoods();
            }
        }
    }

    public void seeAllSupplier() throws SQLException, ClassNotFoundException {
        HashSet<Supplier> suppliers = supplierDAO.selectFromSuppliers();
        System.out.println(suppliers.toString());
        enterGoods();
    }
}
