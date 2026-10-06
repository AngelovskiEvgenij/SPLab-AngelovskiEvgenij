public class Tableofcontents implements Element {
    private String something;

    public Tableofcontents() {
        this("");
    }

    public Tableofcontents(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table of Contents" + (something.isEmpty() ? "" : ": " + something));
    }
}