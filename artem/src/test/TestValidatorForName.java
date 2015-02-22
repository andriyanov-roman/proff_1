import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by artem on 21.02.15.
 */
public class TestValidatorForName {
    public final String PATTERN_FOR_NAME = null;
    public final String PATTERN_FOR_NUMBER = "([0-9]{2,5})";
    public final String PATTERN_FOR_BARCODE = "([0-9]{2,10})";

    @Test
    public void getName() {
        String name = "asfsa";
        if (isTextFieldCorrect(PATTERN_FOR_NAME, name)) {
            name = "dasasd";
        }
        Assert.assertNotNull(PATTERN_FOR_NAME);
    }

    @Test
    public void getType() {
        String type = " asfas";
        if (isTextFieldCorrect(PATTERN_FOR_NAME, type)) {
            type = "asfsad";
        }
        Assert.assertNotNull(PATTERN_FOR_NAME);
    }

    @Test
    public void getNumber() {
        String number = "3133";
        if (isTextFieldCorrect(PATTERN_FOR_NUMBER, number)) {
            number = "31312";
        }
        Assert.assertNotNull(PATTERN_FOR_NUMBER);
    }

    @Test
    public void gerBarCode() {
        String barCode = "12231";
        if (isTextFieldCorrect(PATTERN_FOR_BARCODE, barCode)) {
            barCode = "0";
        }
        Assert.assertNotNull(PATTERN_FOR_BARCODE);
    }

    public boolean isTextFieldCorrect(String pattern, String textField) {
        Matcher matcher = Pattern.compile(pattern).matcher(textField);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

}
