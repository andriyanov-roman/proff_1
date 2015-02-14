package shop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CreateUserList {
    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() throws IOException {
        checkUser();
        return users;
    }

    public void checkUser() throws IOException {
        UserHelper u = new UserHelper();
        u.getUsersFrom();
    }

    private class UserHelper {
        public static final int LOGIN = 0;
        public static final int PASSWORD = 1;

        public void getUsersFrom() throws IOException {
            ArrayList<String[]> lines = getStrings("Yuriy\\src\\main\\resources\\shop\\UsersList.txt");
            for (int i = 0; i < lines.size(); i++) {
                User u = new User();
                u.setLogin(lines.get(i)[LOGIN]);
                u.setPasword(lines.get(i)[PASSWORD]);
                users.add(u);
            }
        }

    }

    public ArrayList<String[]> getStrings(String path) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : Files.readAllLines(Paths.get(path))) {
            strings.add(s);
        }
        ArrayList<String[]> stringsSplit = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            stringsSplit.add(strings.get(i).split(":"));
        }
        return stringsSplit;
    }

}
