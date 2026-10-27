package ro.uvt.services;

import ro.uvt.models.Book;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {
    private final int id;

    public GetBookByIdCommand(int id) {
        this.id = id;
    }

    @Override
    public Optional<Book> execute(CommandContext context) {
        return context.getBooksRepository().findById(id);
    }
}