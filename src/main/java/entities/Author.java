package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(String firstName, String lastName, Short birthYear, Short age, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.age = age;
        this.books = books;
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

    public Author setAge(Short age) {
        this.age = age;
        return this;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Author setBooks(Set<Book> books) {
        this.books = books;
        return this;
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
