import java.awt.Dimension;

public class ImageProxy implements Element, Picture {
    private final String url;
    private Image realImage;

    public ImageProxy(String url) {
        this.url = url;
    }

    private Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Dimension dim() {
        return loadImage().dim();
    }

    @Override
    public ImageContent content() {
        return loadImage().content();
    }

    @Override
    public void print() {
        loadImage().print();
    }
}