public class BookStatistics implements Visitor {
    private int sections = 0;
    private int paragraphs = 0;
    private int images = 0;
    private int tables = 0;
    private int tablesOfContents = 0;

    @Override
    public void visit(Book book) {
        visitChildren(book);
    }

    @Override
    public void visit(Section section) {
        sections++;
        visitChildren(section);
    }

    @Override
    public void visit(Tableofcontents tableofcontents) {
        tablesOfContents++;
    }

    @Override
    public void visit(Paragraph paragraph) {
        paragraphs++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        images++;
    }

    @Override
    public void visit(Table table) {
        tables++;
    }

    public void printStatistics() {
        System.out.println("Book statistics:");
        System.out.println("Sections: " + sections);
        System.out.println("Paragraphs: " + paragraphs);
        System.out.println("Images: " + images);
        System.out.println("Tables: " + tables);
        System.out.println("Tables of contents: " + tablesOfContents);
    }

    private void visitChildren(Section section) {
        for (Element child : section.getChildren()) {
            child.accept(this);
        }
    }
}