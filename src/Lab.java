public class Lab {

    public static void main(String[] args) {
        Book book = new Book("Noapte buna, copii!");
        book.addAuthor(new Author("Radu Pavel Gheo"));

        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap2 = new Section("Capitolul 2");

        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(new ImageProxy("Image subchapter 1.1"));
        cap11.add(new Table("Table 1.1"));
        cap2.add(new Paragraph("Text din capitolul 2"));

        book.addContent(new Paragraph("Multumesc celor care ..."));
        book.addContent(cap1);
        book.addContent(cap2);

        System.out.println("Cuprins generat: ");
        GenerateToc generateToC = new GenerateToc();
        book.accept(generateToC);
        generateToC.getToC().print();

        System.out.println();
        BookStatistics statistics = new BookStatistics();
        book.accept(statistics);
        statistics.printStatistics();

        System.out.println();
        System.out.println("Continut: ");
        book.accept(new RenderContentVisitor());
    }
}