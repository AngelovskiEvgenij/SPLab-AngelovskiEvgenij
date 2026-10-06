import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private final String title;
    private final List<Element> children = new ArrayList<>(); // lista pastreaza ordinea

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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