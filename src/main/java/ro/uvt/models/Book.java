package ro.uvt.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Book extends Section {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Author> authors = new ArrayList<>();

    protected Book() {
    }

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public void setAuthors(List<Author> authors) {
        this.authors = new ArrayList<>(authors);
    }

    public void addContent(Element element) {
        add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void print() {
        System.out.println("Book: " + getTitle());
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        printChildren();
    }
}