package ro.uvt.models;

import java.awt.Dimension;

public interface Picture {
    String url();

    Dimension dim();

    ImageContent content();
}