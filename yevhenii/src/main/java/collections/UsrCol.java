package collections;

/**
 * Created by eugene on 01.02.15.
 */
public class UsrCol {
    private Long id;
    private Integer age;
    private String name;
    private String surname;
    private Boolean gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsrCol usrCol = (UsrCol) o;

        if (!age.equals(usrCol.age)) return false;
        if (!gender.equals(usrCol.gender)) return false;
        if (!id.equals(usrCol.id)) return false;
        if (!name.equals(usrCol.name)) return false;
        if (!surname.equals(usrCol.surname)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "UsrCol{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }
}
