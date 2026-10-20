package ro.uvt.models;

public class Paragraph implements Element {
    private final String text;
    private AlignStrategy alignStrategy;

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