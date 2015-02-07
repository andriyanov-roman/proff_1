package exhw;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by eugene on 30.01.15.
 */
public class Main {
    public static String login() throws LoginExc {
        Scanner scanner = new Scanner(System.in);
        String login = scanner.next();
        LoginExc e = new LoginExc();
        throw e;

    }

    public static void main(String[] args) {


        try {
            login();
        }catch (LoginExc e){
            System.out.println("Wrong login!");

        }
    }
}
