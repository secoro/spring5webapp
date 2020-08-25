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

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ryanHoliday = new Author("Ryan", "Holiday");
        Book dailyStoic = new Book("The Daily Stoic", "123123");
        ryanHoliday.getBooks().add(dailyStoic);
        dailyStoic.getAuthors().add(ryanHoliday);

        authorRepository.save(ryanHoliday);
        bookRepository.save(dailyStoic);

        Author anneCharlish = new Author("Anne", "Charlish");
        Book reiki = new Book("Reiki", "456456");
        anneCharlish.getBooks().add(reiki);
        reiki.getAuthors().add(anneCharlish);

        authorRepository.save(anneCharlish);
        bookRepository.save(reiki);

        System.out.println("Bootstrapping started");
        System.out.println("Number of books in the repository: " + bookRepository.count());

        Publisher publisher1 = new Publisher("Speenkruid 76", "Diemen", "Noord-Holland", "1112NC");
        Publisher publisher2 = new Publisher("Ploegstraat 96", "Amsterdam", "Noord-Holland", "1097WJ");
        Publisher publisher3 = new Publisher("Lulofdwarsstraat 26A", "Den Haag", "Zuid-Holland", "2572AE");

        System.out.println("Saving publishers...");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);
        publisherRepository.save(publisher3);

        System.out.println("Amount of publishers in the repository: " + publisherRepository.count());


    }
}
