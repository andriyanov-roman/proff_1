package kurs.oop;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stringi {
    static String test = "I Pass addresses are binary "
            + "numbers, but they are usually "
            + "stored in text FiLes and displayed "
            + "in human-readable notations, such as 172.16.254.1";
    public static void main(String[] args) {
       String[] words = splitWords();
       int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (isMached(words[i],"^[A-Z]")) {
                String str = words[i].replaceFirst("[A-Z]", "");
                if(isMached(str, "[A-Z]")) {
                  counter++; 
                   System.out.println(words[i]);  
                }
                 
            }
         
            
        }
        
 
    }
    static boolean isMached(String str, String res){
        Pattern p = Pattern.compile(res);
        Matcher m = p.matcher(str);
        return m.find();
    
    }
    static String[] splitWords() {
        String[] result = test.split(" ");
        return result;
    }
    
}
