package entities;

import javax.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FirstName")
    protected String firstName;

    @Column(name = "LastName")
    protected String lastName;

    @Column(name = "BirthYear")
    protected Short birthYear;

    @Column(name = "Age")
    protected Short age;

    public Author() {
    }

    public Author(String firstName, String lastName, Short birthYear, Short age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public Author setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Short getBirthYear() {
        return birthYear;
    }

    public Author setBirthYear(Short birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", age=" + age +
                '}';
    }
}
