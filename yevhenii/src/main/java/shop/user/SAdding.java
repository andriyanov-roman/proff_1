package shop.user;

import shop.Validator;
import shop.db_access.DBsupplier;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by eugene on 18.02.15.
 */
public class SAdding {
   public SAdding(){
        addSupplier();
    }
    Scanner scanner = new Scanner(System.in);
    public void addSupplier(){
        Validator v = new Validator();
        Supplier supplier = new Supplier();
        System.out.println("Enter name:");
        String name = scanner.next();
        if (v.isGoodNameValid(name)) {
            supplier.setName(name);
        }
        System.out.println("Enter good type:");
        String gType = scanner.next();
        if (v.isGoodNameValid(gType)) {
            supplier.setGoodType(gType);
        }
        System.out.println("Enter good id:");
        String id = scanner.next();
        if (v.isGoodQuantityValid(id)) {
            supplier.setGoodId(Integer.parseInt(id));
        }
        System.out.println("Add to DB?" +" "+ "Y/N ");
        String answ = scanner.next();
        if (answ.equalsIgnoreCase("y")){
            DBsupplier dBsupplier = new  DBsupplier();
            try {
                dBsupplier.executeUpdate(supplier);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
