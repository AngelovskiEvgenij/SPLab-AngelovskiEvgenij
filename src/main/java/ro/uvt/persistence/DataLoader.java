package ro.uvt.persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.uvt.models.*;

@Component
public class DataLoader implements CommandLineRunner {
    private final BooksRepository booksRepository;

    public DataLoader(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void run(String... args) {
        if (booksRepository.count() > 0) {
            return;
        }
        Book book = new Book("Noapte buna, copii!");
        book.addAuthor(new Author("Radu Pavel Gheo"));

        Section cap1 = new Section("Capitolul 1");
        cap1.add(new Paragraph("Moto capitol"));
        Section cap11 = new Section("Capitolul 1.1");
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(new ImageProxy("Image subchapter 1.1"));
        cap1.add(cap11);

        book.addContent(new Paragraph("Multumesc celor care ..."));
        book.addContent(cap1);

        booksRepository.save(book);
    }
}