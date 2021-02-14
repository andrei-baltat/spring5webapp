package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
            final AuthorRepository authorRepository,
            final BookRepository bookRepository, final PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domaing Driven Design","1234");
        Publisher manning = new Publisher("Manning","Zaza","Bucharest");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        manning.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(manning);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "1231231232");
        Publisher carturesti = new Publisher("Carturesti","dsdas","Bucharest");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        carturesti.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(carturesti);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books" + bookRepository.count());
        System.out.println("Number of publishers" + publisherRepository.count());

    }
}
