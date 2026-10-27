package ro.uvt.services;

import ro.uvt.models.Author;
import ro.uvt.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<Book>> {
    private final int id;
    private final BookRequest request;

    public UpdateBookCommand(int id, BookRequest request) {
        this.id = id;
        this.request = request;
    }

    @Override
    public Optional<Book> execute(CommandContext context) {
        return context.getBooksRepository().findById(id).map(book -> {
            book.setTitle(request.title());
            if (request.authors() != null) {
                List<Author> authors = new ArrayList<>();
                for (String author : request.authors()) {
                    authors.add(new Author(author));
                }
                book.setAuthors(authors);
            }
            return context.getBooksRepository().save(book);
        });
    }
}