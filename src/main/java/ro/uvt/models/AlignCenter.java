package ro.uvt.models;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Context context) {
        String text = paragraph.getText();
        int padding = Math.max(0, (context.getWidth() - text.length()) / 2);
        System.out.println(" ".repeat(padding) + text);
    }
}