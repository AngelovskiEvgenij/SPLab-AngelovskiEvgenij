package ro.uvt.services;

import ro.uvt.models.Author;
import ro.uvt.models.Book;

public class CreateBookCommand implements Command<Book> {
    private final BookRequest request;

    public CreateBookCommand(BookRequest request) {
        this.request = request;
    }

    @Override
    public Book execute(CommandContext context) {
        Book book = new Book(request.title());
        if (request.authors() != null) {
            for (String author : request.authors()) {
                book.addAuthor(new Author(author));
            }
        }
        return context.getBooksRepository().save(book);
    }
}