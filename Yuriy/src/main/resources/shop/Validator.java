package shop;
import java.io.IOException;
import java.util.ArrayList;

public class Validator {

    public boolean isLoginCorrect(String login) throws IOException, PasswordLoginExcp {
        CreateUserList cu = new CreateUserList();
        ArrayList<User> users = cu.getUsers();

        for (int i = 0; i < users.size(); i++) {
            if (login.equals(users.get(i).getLogin())) {
                return true;
            } else {
                throw new PasswordLoginExcp("");
            }
        }
        return true;
    }
    public boolean isPasswordCorrect(String password){


        return true;
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