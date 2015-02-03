package shop.user;

import shop.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eugene on 01.02.15.
 */
public class Authentification {
    public static Scanner scanner = new Scanner(System.in);
    UserBase u = new UserBase();
    int counter = 5;
    User user = new User();




    public void verify() throws IOException {

        System.out.println("Enter your login:");
        String login = scanner.next();
        System.out.println("Enter your password:");
        String pass = scanner.next();
        user.setLogin(login);
        user.setPassword(pass);
        login();


    }

    public void login() throws IOException {
        boolean log = false;
        boolean pw = false;
        for (int i = 0; i < u.getUsr().size(); i++) {
            if (u.getUsr().get(i).getLogin().equals(user.getLogin())) {
                log = true;

                for (int j = 0; j < u.getUsr().size(); j++) {
                    if (u.getUsr().get(i).getPassword().equals(user.getPassword())) {
                        pw = true;


                    } /*else if (counter == 0) {
                            break;
                        }*//* else {



                        }*/
                }
            }
        }
        if (log & pw) {
            enter();

        } else if (counter != 0) {
            if (!log || !pw) {
                counter--;
                System.out.println("Invalid login or password" + "\n" +
                        "Try again");
                System.out.println(counter + " " + "tries left");

                verify();
            }
        } else if (counter <= 0) {
            System.out.println("Fuck off");

        }

    }



    private void enter() throws IOException {

        new View();
    }

    public void log() throws IOException {

        verify();

    }
}
