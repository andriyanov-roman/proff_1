package my_exceptions;

import java.util.Scanner;

public class View {
    public Scanner sc = new Scanner(System.in);
    public LoginValidator loginValidator = new LoginValidator();

    public View() {
        start();
    }

    public void start() {
        User user = new User();
        System.out.println("Enter login:");
        while (sc.hasNext()) {
            user.setLogin(enterLogin());
            System.out.println("Enter password:");
            user.setPassword(enterPassword());
            System.out.println("OK");
            break;
        }
    }

    private String enterLogin() {
        String login;
        try {
            login = sc.next();
            if (loginValidator.isLoginCorrect(login)) {
                return login;
            } else throw new LoginException();
        } catch (LoginException e) {
            System.out.println("Try again!");
            login = enterLogin();
        }
        return login;
    }

    private String enterPassword() {
        String password = sc.next();
        return password;
    }
}

