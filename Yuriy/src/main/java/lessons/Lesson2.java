package lessons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson2 {

    static String wiki = "Johannes Kepler was a German 127. Lutheran mathemaTician, astronoMer and.0. astrologer, and a key " +
            "figure in the 17th century astronomical revolution. He is best known for his eponymous laws of planetary " +
            "motion, codified by later.0. astronomers based was  on his works Astronomia nova, Harmonices Mundi, and Epitome of " +
            "Copernican Astronomy. Before Kepler, planets' paths were computed by.1 combinations of thewas  circular motions of " +
            "the celestial orbs.";


    public static void main(String[] args) {
        String[] str = splitStringToWords();


        int counter = 0;
        for (int i = 0; i < str.length; i++) {
            if (isMatched(str[i], "\\.[0-9]")) {
                counter++;
            }
        }



        String[] findStringsArrays = new String[counter];
        int counter2 = 0;
        for (int i = 0; i < str.length; i++) {
            if (isMatched(str[i], "\\.[0-9]")) {
                findStringsArrays[counter2] = str[i];
                counter2++;
            }
        }
        for (int i = 0; i < findStringsArrays.length; i++) {
            System.out.println(findStringsArrays[i]);
        }

    }

    static boolean isMatched(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        return m.find();
    }


    static String[] splitStringToWords() {
        String[] resaltString = wiki.split(" ");
        return resaltString;
    }


}
