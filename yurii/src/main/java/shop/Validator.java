package shop;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    UserDAOImpl userDAO = new UserDAOImpl();
    GoodDAOImpl goodDAO = new GoodDAOImpl();

    public boolean isUserAllrExist(User usery) throws SQLException {
        Set<User> userSet = userDAO.selectFromUsers();
        if (userSet.contains(usery)) {
            return true;
        }
        return false;
    }

    public boolean isGoodAllrExist(Good goody) throws SQLException {
        Set<Good> goodSet = goodDAO.selectGood();
        new HashSet<>();
        if (goodSet.contains(goody)) {
            return true;
        }
        return false;
    }

    public boolean isLoginAndPasswordCorrect(User user) throws IOException, SQLException {
        HashSet<User> userSet = userDAO.selectFromUsers();
        if (userSet.contains(user)) {
            return true;
        }
        return false;
    }


    public boolean isGoodNameValid(String goodValue) {
        if (goodValue == null) {
            return false;
        }
        return true;
    }

    public boolean isGoodAmountValid(String good) {
        if (good == null) {
            return false;
        }
        return true;
    }

    public boolean isGoodBarcodeValid(String code) {
        if (code == null) {
            return false;
        }
        return true;
    }

    public boolean isGoodTypeValid(String type) {
        if (type == null) {
            return false;
        }
        return true;
    }

}
