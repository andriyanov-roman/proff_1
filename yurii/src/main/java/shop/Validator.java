package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Validator {

       public boolean isUserAllrExist(User usery) throws SQLException {
        Set<User> userSet = new HashSet<>();
        String sql = "SELECT * FROM users";
        PreparedStatement statement = ConnectDB.getConnectoin().prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            String login = result.getString("user_login");
            String password = result.getString("user_password");
            User u = new User();
            u.setLogin(login);
            u.setPasword(password);
            userSet.add(u);
        }
        if (userSet.contains(usery)) {
            return true;
        }
        return false;
    }

    public boolean isGoodAllrExist(Good goody) throws SQLException {
        Set<Good> goodSet = new HashSet<>();
        String sql = "SELECT * FROM  goods";
        PreparedStatement statement = ConnectDB.getConnectoin().prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            String name = result.getString("good_name");
            int qty = result.getInt("good_qty");
            int barcode = result.getInt("barcode");
            String type = result.getString("good_type");
            Good good = new Good();
            good.setName(name);
            good.setAmount(qty);
            good.setBarcode(barcode);
            good.setType(type);
            goodSet.add(good);
        }
        if (goodSet.contains(goody)) {
            return true;
        }
        return false;
    }

    public boolean isLoginCorrect(String login) throws IOException {
        CreateUserList cu = new CreateUserList();
        ArrayList<User> users = cu.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (login.equals(users.get(i).getLogin())) {
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordCorrect(String password) throws IOException {
        CreateUserList cu = new CreateUserList();
        ArrayList<User> users = cu.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (password.equals(users.get(i).getPasword())) {
                return true;
            }
        }
        return false;
    }

    public boolean isGoodNameValid(String goodValue) {
        if (goodValue == null) {
            return false;
        }
        return true;
    }

    public boolean isGoodAmount(String good) {
        if (good == null) {
            return false;
        }
        return true;
    }

    public boolean isGoodBarcode(String code) {
        if (code == null) {
            return false;
        }
        return true;
    }

    public boolean isGoodType(String type) {
        if (type == null) {
            return false;
        }
        return true;
    }

}
