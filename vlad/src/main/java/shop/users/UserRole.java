package shop.users;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "userRole")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 3L;
    @Id
    @Column(name = "id1")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;


    public UserRole() {
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
        if (o == null || getClass() != o.getClass()) return false;

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

