package ro.uvt.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tableofcontents extends BaseElement {
    private String something;

    @ElementCollection
    private List<String> entries = new ArrayList<>();

    public Tableofcontents() {
        this("");
    }

    public Tableofcontents(String something) {
        this.something = something;
    }

    public String getSomething() {
        return something;
    }

    public List<String> getEntries() {
        return entries;
    }

    public void addEntry(String title, int level) {
        entries.add("  ".repeat(level) + title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void print() {
        System.out.println("Table of Contents" + (something == null || something.isEmpty() ? "" : ": " + something));
        for (String entry : entries) {
            System.out.println(entry);
        }
    }
}