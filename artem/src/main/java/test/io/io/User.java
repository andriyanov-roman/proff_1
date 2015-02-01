package test.io.io;

import java.io.Serializable;

/**
 * Created by artem on 31.01.15.
 */
public class User implements Serializable{
    private  transient String login;
    private  transient String password;
    private  transient int age;
    private  transient String name;
    private  transient String secondname;

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

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
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
    public String toString(){
        return getPassword()+getLogin()+getName()+getSecondname()+getAge();
    }

}
