package ro.uvt.models;

public class RenderContentVisitor implements Visitor {

    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println("Authors:");
        for (Author author : book.getAuthors()) {
            author.print();
        }
        visitChildren(book);
    }

    @Override
    public void visit(Section section) {
        System.out.println(section.getTitle());
        visitChildren(section);
    }

    @Override
    public void visit(Tableofcontents tableofcontents) {
        tableofcontents.print();
    }

    @Override
    public void visit(Paragraph paragraph) {
        paragraph.print();
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        imageProxy.print();
    }

    @Override
    public void visit(Table table) {
        table.print();
    }

    private void visitChildren(Section section) {
        for (Element child : section.getChildren()) {
            child.accept(this);
        }
    }
}