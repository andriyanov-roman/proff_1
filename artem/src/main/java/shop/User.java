package shop;

/**
 * Created by artem on 31.01.15.
 */
public class User {
    String Login;
    String password;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String  getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Login='" + Login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
