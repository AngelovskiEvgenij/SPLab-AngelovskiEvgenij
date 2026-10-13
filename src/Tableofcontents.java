import java.util.ArrayList;
import java.util.List;

public class Tableofcontents implements Element {
    private final String something;
    private final List<String> entries = new ArrayList<>();

    public Tableofcontents() {
        this("");
    }

    public Tableofcontents(String something) {
        this.something = something;
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
        System.out.println("Table of Contents" + (something.isEmpty() ? "" : ": " + something));
        for (String entry : entries) {
            System.out.println(entry);
        }
    }
}