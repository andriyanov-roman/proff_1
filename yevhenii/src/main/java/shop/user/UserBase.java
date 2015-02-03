package shop.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by eugene on 01.02.15.
 */
public class UserBase {


    private static final int LOGIN = 0;
    private static final int PASSWORD = 1;

    private ArrayList<String[]> getStrings() throws IOException {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String[]> strings = new ArrayList<>();

        File file = new File("/home/eugene/proff_repos/proff_1/yevhenii/src/main/java/shop/user/UsrDB");
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

   public ArrayList<User> getUsr() throws IOException {
      ArrayList<User> usr = new ArrayList<>();
        for (int i = 0; i < getStrings().size(); i++) {

            User user = new User();
            user.setLogin((getStrings().get(i)[LOGIN]));
            user.setPassword((getStrings().get(i)[PASSWORD]));
            usr.add(user);
        }


       return usr;
   }


}

