package ro.uvt.models;

import jakarta.persistence.*;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

@Entity
public class Image extends BaseElement implements Picture {
    private String url;

    @Transient
    private Dimension dim = new Dimension(1920, 1080);

    @Transient
    private ImageContent content;

    protected Image() {
    }

    public Image(String name) {
        this.url = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = new ImageContent(name);
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