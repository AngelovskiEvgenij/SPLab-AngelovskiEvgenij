package ro.uvt.services;

import ro.uvt.models.Book;
import ro.uvt.persistence.CrudRepository;

public class CommandContext {
    private final CrudRepository<Book, Integer> booksRepository;

    public CommandContext(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public CrudRepository<Book, Integer> getBooksRepository() {
        return booksRepository;
    }
}