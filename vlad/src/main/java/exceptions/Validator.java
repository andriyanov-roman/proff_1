package exceptions;

/**
 * Created by root on 25.01.15.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean isGoodNameValid(String goodValue) {
        Matcher matcher = Pattern.compile("([A-Z]{1}[a-z]{2,15})").matcher(goodValue);
        if (matcher.matches()) {
            return true;
        } else return false;


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
