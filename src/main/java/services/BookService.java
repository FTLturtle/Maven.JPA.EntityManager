package services;

import entities.Book;
import entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Set;

public class BookService {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public BookService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = entityManager.getTransaction();
    }

    public Book create(String title, Short publicationYear, Float price, String isbn, String genre, Long wordCount, Set<Author> authors) {

        Book book = new Book();
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setPrice(price);
        book.setIsbn(isbn);
        book.setGenre(genre);
        book.setWordCount(wordCount);
        book.setAuthors(authors);

        return create(book);
    }

    public Book create(Book book) {
        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();
        return book;
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        return entityManager.createQuery("select a from Book a").getResultList();
    }

    public Book update(Long id, Book updates) {
        Book book = findById(id);
        if (book != null) {
            entityTransaction.begin();
            copyFieldsFromSecondBookToFirst(book, updates);
            entityTransaction.commit();
        }
        return book;
    }

    public void copyFieldsFromSecondBookToFirst(Book copyTo, Book copyFrom) {
        copyTo.setTitle(copyFrom.getTitle());
        copyTo.setPublicationYear(copyFrom.getPublicationYear());
        copyTo.setPrice(copyFrom.getPrice());
        copyTo.setIsbn(copyFrom.getIsbn());
        copyTo.setGenre(copyFrom.getGenre());
        copyTo.setWordCount(copyFrom.getWordCount());
        copyTo.setAuthors(copyFrom.getAuthors());
    }

    public void delete(Long id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityTransaction.begin();
            entityManager.remove(book);
            entityTransaction.commit();
        }
    }

    public void delete(Book book) {
        Book bookToBeDeleted = entityManager.merge(book);
        entityTransaction.begin();
        entityManager.remove(bookToBeDeleted);
        entityTransaction.commit();
    }

}
