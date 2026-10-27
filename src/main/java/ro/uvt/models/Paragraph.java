package ro.uvt.models;

import jakarta.persistence.*;

@Entity
public class Paragraph extends BaseElement {

    @Column(length = 2000)
    private String text;

    @Transient
    private AlignStrategy alignStrategy;

    protected Paragraph() {
    }

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void print() {
        if (alignStrategy == null) {
            System.out.println(text);
        } else {
            alignStrategy.render(this, new Context());
        }
    }
}