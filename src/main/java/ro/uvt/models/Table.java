package ro.uvt.models;

public class Table implements Element {
    private String something;

    public Table(String something) {
        this.something = something;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void print() {
        System.out.println("Table: " + something);
    }
}