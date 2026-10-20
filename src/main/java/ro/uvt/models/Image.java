package ro.uvt.models;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

public class Image implements Element, Picture {
    private final String url;
    private final Dimension dim = new Dimension(1920, 1080);
    private final ImageContent content;

    public Image(String name) {
        url = name;
        try {
            TimeUnit.SECONDS.sleep(5); // simuleaza incarcarea unei imagini mari
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        content = new ImageContent(name);
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Dimension dim() {
        return dim;
    }

    @Override
    public ImageContent content() {
        return content;
    }

    @Override
    public void accept(Visitor visitor) {
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + url);
    }
}