package shop.users;

import shop.users.User;

import java.util.ArrayList;

public class UserBase {

    public ArrayList<User> getUserBase() {
        ArrayList<User> users = new ArrayList<>();

        User u1 = new User("lele", "lele");
        User u2 = new User("Zhenya", "123");
        User u3 = new User("Vlad", "qwerty");
        User u4 = new User("PussyRider", "1234");
        User u5 = new User("12", "1223");

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);

        return users;
    }

}
