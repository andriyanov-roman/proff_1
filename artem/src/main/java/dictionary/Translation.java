package dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by artem on 10.02.15.
 */
public class Translation {
    private Scanner scanner = new Scanner(System.in);

    public Map getDictionary() {
        Map<String, String> dictionary = new HashMap();
        dictionary.put("string", "строка");
        dictionary.put("object", "объект");
        dictionary.put("user", "пользователь");
        dictionary.put("number", "номер");
        dictionary.put("main", "главный");
        dictionary.put("target", "цель");
        dictionary.put("control", "контроль");
        return dictionary;
    }

    public void translate() {
        while (scanner.hasNext()) {
            Map<String, String> words = getDictionary();
            String word = scanner.next();
            for (Map.Entry<String, String> d : words.entrySet()) {
                if (word.equals(d.getKey())) {
                    System.out.println(d.getKey() + " " + d.getValue());
                }
                if (word.equals(d.getValue())) {
                    System.out.println(d.getKey() + " " + d.getValue());
                }
            }
            translate();
        }
    }
}
