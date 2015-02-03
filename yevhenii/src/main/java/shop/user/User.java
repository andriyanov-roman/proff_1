package shop.user;

import java.util.ArrayList;

/**
 * Created by eugene on 01.02.15.
 */
public class User {
    private String login;
    private String password;



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    @Override
    public String toString() {
        return login + " " + password;
    }
}
