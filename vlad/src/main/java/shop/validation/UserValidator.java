package shop.validation;

import shop.users.UserBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public boolean isUserCorrect(String login, String password) {
        UserBase userBase = new UserBase();

        for (int i = 0; i < userBase.getUserBase().size(); i++) {
            if (userBase.getUserBase().get(i).getLogin().equals(login) && userBase.getUserBase().get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
