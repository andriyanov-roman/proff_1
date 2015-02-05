package shop;


public class User {
    String login;
    String pasword;

    @Override
    public String toString() {
        return
                "login " + login + ": pasword " + pasword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
