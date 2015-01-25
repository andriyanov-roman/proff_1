package kurs.oop.user;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user = new User ();
        user.setName("Ololo");
        user.setLogin  ("asd");
        user.setPass ("asd123");

        User userTwo = new User ();
        userTwo.setName("Lila");
        userTwo.setLogin  ("asd");
        userTwo.setPass ("asd1231");

        User userThree = new User ();
        userThree.setName("Olya");
        userThree.setLogin  ("asd");
        userThree.setPass ("asd1231");

        User userFor = new User ();
        userFor.setName("Alan");
        userFor.setLogin  ("asd");
        userFor.setPass ("asd123123");

        User userFive = new User ();
        userFive.setName("Sy4ka");
        userFive.setLogin  ("asd");
        userFive.setPass ("asd12312323");

        ArrayList<User> userArrayList = new ArrayList<User>();
        userArrayList.add(user);
        userArrayList.add(userTwo);
        userArrayList.add(userThree);
        userArrayList.add(userFor);
        userArrayList.add(userFive);

        System.out.println(longestPassword(userArrayList).getName());


    }
    public static User longestPassword (ArrayList <User> userArrayList){
        User maxpass = userArrayList.get(0);
        for (int i = 0; i < userArrayList.size() ; i++) {
            if (maxpass.getPass().length() < userArrayList.get(i).getPass().length());
            maxpass = userArrayList.get(i);
        }
        return maxpass;
    }


}
