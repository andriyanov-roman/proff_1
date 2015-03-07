package person;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Persons")
public class Person implements Serializable {
    static final long serialVersionUID = -7593775012501239455L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  @Column(name = "personId")
    private Long id;
    @Column(name = "fName")
    private String firstName;
    @Column(name = "sName")
    private String secondName;

    public Person() {
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (secondName != null ? !secondName.equals(person.secondName) : person.secondName != null)                                     return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}