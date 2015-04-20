package shop.control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by artem on 24.01.15.
 */
public class Validator {
    public static final String PATTERN_FOR_NAME = "([A-Z]{1}[a-z]{2,15})";
    public static final String PATTERN_FOR_NUMBER = "([0-9]{2,5})";
    public static final String PATTERN_FOR_BARCODE = "([0-9]{2,10})";

    public boolean getName(String name) {
        if (isTextFieldCorrect(PATTERN_FOR_NAME, name)) {
            return true;
        }
        return false;
    }

    public boolean getType(String type) {
        if (isTextFieldCorrect(PATTERN_FOR_NAME, type)) {
            return true;
        }
        return false;
    }

    public boolean getNumber(String  number) {
        if (isTextFieldCorrect(PATTERN_FOR_NUMBER, number)) {
            return true;
        }
        return false;
    }

    public boolean gerBarCode(String barCode) {
        if (isTextFieldCorrect(PATTERN_FOR_BARCODE, barCode)) {
            return true;
        }
        return false;
    }

    public boolean isTextFieldCorrect(String pattern, String textField) {
        Matcher matcher = Pattern.compile(pattern).matcher(textField);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

}
