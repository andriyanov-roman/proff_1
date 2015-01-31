package exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator {
    private static final String LOGIN_PATTERN = "([A-Z]{1}[a-z]{2,15})";

    public boolean isLoginCorrect(String login){
        Matcher matcher = Pattern.compile(LOGIN_PATTERN).matcher(login);
        if (matcher.matches()) {
            return true;
        } else return false;
    }
}
