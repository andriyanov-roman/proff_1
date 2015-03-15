package shop.validation;

import shop.db_access.UserDAO;
import shop.users.User;
import shop.users.UserBase;
import shop.users.UserUtility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    UserDAO userDAO = new UserDAO();
    UserUtility userUtility = new UserUtility();

    public boolean isUserCorrect(String login, String password) {
        UserBase userBase = new UserBase();

        for (int i = 0; i < userBase.getUserBase().size(); i++) {
            if (userBase.getUserBase().get(i).getLogin().equals(login) && userBase.getUserBase().get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean userExists(User user) {
        if (userUtility.selectAll().contains(user)) {
            return true;
        } else {
            return false;
        }
    }
}
