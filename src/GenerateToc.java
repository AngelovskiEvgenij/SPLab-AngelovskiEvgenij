public class GenerateToc implements Visitor {
    private final Tableofcontents toc = new Tableofcontents();
    private int level = 0;

    public Tableofcontents getToC() {
        return toc;
    }

    @Override
    public void visit(Book book) {
        visitChildren(book);
    }

    @Override
    public void visit(Section section) {
        toc.addEntry(section.getTitle(), level);
        level++;
        visitChildren(section);
        level--;
    }

    @Override
    public void visit(Tableofcontents tableofcontents) { }

    @Override
    public void visit(Paragraph paragraph) { }

    @Override
    public void visit(ImageProxy imageProxy) { }

    @Override
    public void visit(Table table) { }

    private void visitChildren(Section section) {
        for (Element child : section.getChildren()) {
            child.accept(this);
        }
    }
}