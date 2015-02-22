import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eugene on 21.02.15.
 */
public class ValidatorTest {
    @Test
    public void valTest() {
        String goodValue = ";;e";
        Matcher matcher = Pattern.compile("[0-9]+").matcher(goodValue);
Assert.assertTrue(goodValue, matcher.matches());
        /*public boolean isGoodNameValid(String goodValue) {
            if (goodValue == null) {
                return false;
            }
            return true;
        }*/

    /*public boolean isGoodQuantityValid(String goodValue) {
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

    }*/

    }
}