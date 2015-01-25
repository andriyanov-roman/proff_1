package exceptionsExample;


public class Validator {

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
