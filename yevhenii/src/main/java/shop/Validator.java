package shop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eugene on 01.02.15.
 */
public class Validator {
    public boolean isGoodNameValid(String goodValue) {
        if (goodValue == null) {
            return false;
        }
        return true;
    }

    public boolean isGoodQuantityValid(String goodValue) {
        Matcher matcher = Pattern.compile("[0-9]+").matcher(goodValue);
        if (matcher.matches()) {
            return true;
        } else return false;

    }

    public boolean isGoodBarcodeValid(String goodValue) {
        Matcher matcher = Pattern.compile("[0-9]+").matcher(goodValue);
        if (matcher.matches()) {
            return true;
        } else return false;

    }

    public boolean isGoodTypeValid(String goodValue) {
        if (goodValue == null) {
            return false;
        }
        return true;
    }
}
