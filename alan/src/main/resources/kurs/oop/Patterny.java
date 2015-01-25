package kurs.oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterny {
  static String TEST_TWO = "Robert";
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[A]");
        Matcher matcher = p.matcher(TEST_TWO);
        if(matcher.find()) {
            System.out.println("1");
        }

    }

    
}
