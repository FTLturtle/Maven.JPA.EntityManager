package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "PublicationYear")
    private Short publicationYear;

    @Column(name = "Price")
    private Float price;

    @Column(name = "Isbn")
    private String isbn;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "WordCount")
    private Long wordCount;

    //@OneToMany()
    @OneToMany(cascade = ALL, fetch = FetchType.EAGER) // {PERSIST, REMOVE, MERGE, ALL}, EAGER || LAZY
    //@JoinColumn(name = "cd_fk")
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String title, Short publicationYear, Float price, String isbn, String genre, Long wordCount, Set<Author> authors) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
        this.isbn = isbn;
        this.genre = genre;
        this.wordCount = wordCount;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Short getPublicationYear() {
        return publicationYear;
    }

    public Book setPublicationYear(Short publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public Book setPrice(Float price) {
        this.price = price;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Book setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public Long getWordCount() {
        return wordCount;
    }

    public Book setWordCount(Long wordCount) {
        this.wordCount = wordCount;
        return this;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public Book setAuthors(Set<Author> authors) {
        this.authors = authors;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", wordCount=" + wordCount +
                ", authors=" + authors +
                '}';
    }
}
