package shop.userright;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import shop.User;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "userrole")
public class UserRole implements Serializable {

    static final long serialVersionUID = -7593775012501239455L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "login")
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public UserRole() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRight = (UserRole) o;

        if (id != userRight.id) return false;
        if (name != null ? !name.equals(userRight.name) : userRight.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserRight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
