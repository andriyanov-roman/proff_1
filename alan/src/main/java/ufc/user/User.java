package ufc.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reg")

public class User implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @Column(name = "reg_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "reg_name")
    private String login;
    @Column(name = "reg_pass")
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

    public User (String login, String password){
        this.login = login;
        this.password = password;
    }

    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
