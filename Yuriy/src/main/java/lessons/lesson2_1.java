package lessons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lesson2_1 {
    static String TEST_TWO = "Johannes Kepler was a German 127. Lutheran mathemaTician, astronoMer and.0. astrologer, and a key \" +\n" +
            "            \"figure in the 17th century astronomical revolution. He is best known for his eponymous laws of planetary \" +\n" +
            "            \"motion, codified by later.0. astronomers based was  on his works Astronomia nova, Harmonices Mundi, and Epitome of \" +\n" +
            "            \"Copernican Astronomy. Before Kepler, planets' paths were computed by.1. combinations of thewas  circular motions of \" +\n" +
            "            \"the celestial orbs.";



    public static void main(String[] args) {
        Pattern p = Pattern.compile("[127\\.0\\.0\\.1\\.]");
        Matcher m = p.matcher(TEST_TWO);
       while (m.find()){
           System.out.print(m.group());
       }

    }
}
