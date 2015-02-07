package test.io.colections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by artem on 01.02.15.
 */
public class Main {
    public static void main(String[] args) {
        User user=new User();
        user.setAge(1);
        user.setName("qwr");
        user.setGender(true);
        user.setSurname("qwrrq");
        User user1=new User();
        user1.setAge(1);
        user1.setName("qwr");
        user1.setGender(true);
        user1.setSurname("qwrrq");
        Set <User> users=new HashSet<>();
        users.add(user);
        users.add(user1);
        System.out.println(users.size());
    }
}
