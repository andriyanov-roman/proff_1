package shop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlUser {
    public  ArrayList<User> getUsers() throws FileNotFoundException {
        ArrayList<String[]> strings = getStrings("/home/artem/proff_repos/proff_1/artem/src/main/java/shop/users");
        ArrayList <User> users=new ArrayList<User>();
        for (int i = 0; i <strings.size() ; i++) {
           User user=new User();
            user.setLogin(strings.get(i)[0]);
            user.setPassword(strings.get(i)[1]);
            users.add(user);
        }
        return users;
    }

    public boolean checkUser(String login, String password) throws MyException, FileNotFoundException {
        for (int i = 0; i <getUsers().size() ; i++) {
            if(getUsers().get(i).getLogin().equals(login) && getUsers().get(i).getPassword().equals(password)){
              return true;
            }
        }
        throw new MyException("Not valid login or password");
    }

    public  ArrayList<String[]> getStrings(String path) throws FileNotFoundException {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String[]> strings = new ArrayList<>();
        File file = new File(path);
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            stringList.add(s.next());
        }
        for (int i = 0; i < stringList.size(); i++) {
            strings.add(stringList.get(i).split(":"));
        }
        return strings;
    }
}
