package ro.uvt.observers;

import ro.uvt.models.Book;

public interface Observer {
    void update(Book book);
}