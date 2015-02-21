package servlets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tatty on 21.02.2015.
 */
public class GoodsHandler {

    public List<String> getTypes(String taste) {
        List<String> result = new ArrayList<String>();
        if (taste.equals("milk")) {
            result.add("milk1");
            result.add("milk1");
        } else if (taste.equals("bread")) {
            result.add("bread1");
            result.add("bread2");
        } else if (taste.equals("ice")) {
            result.add("icecream");
        } else if (taste.equals("alcohol")) {
            result.add("vodka");
            result.add("bear");
        } else {
            result.add("not recognize");
        }
        return (result);
    }
}
