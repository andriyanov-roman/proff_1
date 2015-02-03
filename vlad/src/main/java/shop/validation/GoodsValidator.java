package shop.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoodsValidator {

    public boolean isGoodNameValid(String goodValue) {
        Matcher matcher = Pattern.compile("[A-Z]+[a-z-A-Z]*").matcher(goodValue);
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
        Matcher matcher = Pattern.compile("[A-Z]+[a-z-A-Z]*").matcher(goodValue);
        if (matcher.matches()) {
            return true;} else return false;
    }
}
