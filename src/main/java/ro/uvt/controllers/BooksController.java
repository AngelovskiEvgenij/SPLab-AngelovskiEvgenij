package ro.uvt.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.models.Book;
import ro.uvt.persistence.CrudRepository;
import ro.uvt.services.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final CommandContext context;

    public BooksController(CrudRepository<Book, Integer> booksRepository) {
        this.context = new CommandContext(booksRepository);
    }

    @GetMapping
    public List<Book> getAll() {
        return new GetAllBooksCommand().execute(context);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id) {
        return new GetBookByIdCommand(id).execute(context)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody BookRequest request) {
        Book created = new CreateBookCommand(request).execute(context);
        return ResponseEntity.status(HttpStatus.CREATED).body(created.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody BookRequest request) {
        return new UpdateBookCommand(id, request).execute(context)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return new DeleteBookCommand(id).execute(context)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}