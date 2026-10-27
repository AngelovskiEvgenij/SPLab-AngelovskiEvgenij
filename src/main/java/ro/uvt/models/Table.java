package ro.uvt.models;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "TableElement")
public class Table extends BaseElement {
    private String something;

    protected Table() {
    }

    public Table(String something) {
        this.something = something;
    }

    public String getSomething() {
        return something;
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