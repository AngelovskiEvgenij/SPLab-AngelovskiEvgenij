package ro.uvt.models;

public interface Element {
    void print();

    void accept(Visitor visitor);

    default void add(Element element) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " cannot contain other elements");
    }

    default void remove(Element element) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " cannot contain other elements");
    }

    default Element get(int index) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " cannot contain other elements");
    }
}