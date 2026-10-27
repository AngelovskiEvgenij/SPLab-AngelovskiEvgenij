package ro.uvt.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Section extends BaseElement {
    private String title;

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn
    private List<Element> children = new ArrayList<>();

    protected Section() {
    }

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Element> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void add(Element element) {
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        children.remove(element);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void print() {
        System.out.println(title);
        printChildren();
    }

    protected void printChildren() {
        for (Element child : children) {
            child.print();
        }
    }
}