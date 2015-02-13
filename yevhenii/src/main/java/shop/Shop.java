package shop;

import shop.sort.SortByBarCode;
import shop.user.Authentification;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by eugene on 04.02.15.
 */
public class Shop {
    public Shop() throws IOException {
        Authentification u = new Authentification();
        u.log();
    }
   public Set<Good> getSortedG() throws IOException {
Set<Good> sorted = new TreeSet<>(new SortByBarCode());
sorted.addAll(getAllGoods());
       return sorted;
   }
    public ArrayList<Good> getAllGoods() throws IOException {
        ArrayList<Good> g = new ArrayList<>();
        for (int i = 0; i < getStrings().size(); i++) {

            Good good = new Good();
            good.setName((getStrings().get(i)[0]));
            good.setQuantity(Integer.parseInt((getStrings().get(i)[1])));
            good.setCode(Long.parseLong(getStrings().get(i)[2]));
            good.setType(getStrings().get(i)[3]);
            g.add(good);
        }


        return g;
    }
    private ArrayList<String[]> getStrings() throws IOException {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String[]> strings = new ArrayList<>();

        File file = new File("/home/eugene/proff_repos/proff_1/yevhenii/src/main/java/shop/view/report");
        FileReader reader = new FileReader(file);
        BufferedReader bfReader = new BufferedReader(reader);
        String line;
        while ((line = bfReader.readLine()) != null) {
            stringList.add(line);
        }
        reader.close();
        for (int i = 0; i < stringList.size(); i++) {
            strings.add(stringList.get(i).split(":"));
        }
        return strings;
    }

}
