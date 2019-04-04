import entities.Book;
import entities.Author;
import services.BookService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class MainRunner {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("publishing");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BookService bookService = new BookService(entityManager);

        Book book = createNewBook();

        // Create then Read
        book = bookService.create(book);
        System.out.println(bookService.findById(book.getId()));
        System.out.println(bookService.findAll());

        // Update then Read
        book.setGenre("Pretentious Crap");
        book.setPrice(0.000001F);
        bookService.update(book.getId(), book);
        System.out.println(bookService.findById(book.getId()));
        System.out.println(bookService.findAll());

        // Delete then Read
//        bookService.delete(book.getId());
//        System.out.println(bookService.findById(book.getId()));
//        System.out.println(bookService.findAll());
    }

    private static Book createNewBook() {
        Set<Author> authorSet = new HashSet<>();
        authorSet.add(new Author("Wilhem", "Alcivar", (short) 1000, (short) 1019, new HashSet<>()));
        authorSet.add(new Author("Dolio", "Durant", (short) 1000, (short) 1019, new HashSet<>()));
        authorSet.add(new Author("Leon", "Hunter", (short) 1000, (short) 1019, new HashSet<>()));
        authorSet.add(new Author("Froilan", "Miranda", (short) 1000, (short) 1019, new HashSet<>()));
        authorSet.add(new Author("Nhu", "Nguyen", (short) 1000, (short) 1019, new HashSet<>()));
        authorSet.add(new Author("Kris", "Younger", (short) 1000, (short) 1019, new HashSet<>()));

        return new Book("The Zipcode Manifesto", (short) 2015, 10000F, "1234567890", "Wisdom Literature", 1000000000L, authorSet);
    }
}
