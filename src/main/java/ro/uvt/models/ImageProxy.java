package ro.uvt.models;

import jakarta.persistence.*;
import java.awt.Dimension;

@Entity
public class ImageProxy extends BaseElement implements Picture {
    private String url;

    @Transient
    private Image realImage;

    protected ImageProxy() {
    }

    public ImageProxy(String url) {
        this.url = url;
    }

    private Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    public String getUrl() {
        return url;
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
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void print() {
        loadImage().print();
    }
}