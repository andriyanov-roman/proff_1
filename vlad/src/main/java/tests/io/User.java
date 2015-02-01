package tests.io;

import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private String surname;
    private int age;
    private String login;
    private transient String password;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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
        return "User " +
                "age " + age +
                ", name " + name +
                ", surname " + surname +
                ", login " + login  +
                ", password " + password;

    }
}
