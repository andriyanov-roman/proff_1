package collections;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by eugene on 01.02.15.
 */
public class Main {
    public static void main(String[] args) {
       UsrCol user = new UsrCol();
        user.setName("1");
        user.setSurname("Durak");
        user.setAge(12);
        user.setGender(false);
        user.setId(12345L);

        UsrCol user1 = new UsrCol();
        user1.setName("2");
        user1.setSurname("Durak");
        user1.setAge(12);
        user1.setGender(false);
        user1.setId(12345L);

        UsrCol user2 = new UsrCol();
        user2.setName("3");
        user2.setSurname("Durak");
        user2.setAge(12);
        user2.setGender(false);
        user2.setId(12345L);

        UsrCol user3 = new UsrCol();
        user3.setName("4");
        user3.setSurname("Durak");
        user3.setAge(12);
        user3.setGender(false);
        user3.setId(12345L);

        System.out.println(user.hashCode() + " " + user3.hashCode());

        Set<UsrCol> users = new HashSet<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        for (UsrCol u : users) {
            System.out.println(u.toString());
        }

     LinkedList linkedList = new LinkedList();
     linkedList.add(1);
     linkedList.add(2);
     linkedList.add(3);
     linkedList.add(4);
     linkedList.add(5);


        System.out.println(users.size());
    }
}
