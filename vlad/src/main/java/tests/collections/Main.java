package tests.collections;

import tests.io.User;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User us1 = new User();
        us1.setName("Vlad");
        us1.setAge(1);
        us1.setGender(true);
        us1.setSecondName("K");
        us1.setId(12321L);

        User us2 = new User();
        us2.setName("Vlad");
        us2.setAge(1);
        us2.setGender(true);
        us2.setSecondName("K");
        us2.setId(12321L);

        Set<User> users = new HashSet<>();
        users.add(us1);
        users.add(us2);

        for(User u : users){
            System.out.println(u.hashCode());
        }
        System.out.println(users.size());
    }
}
