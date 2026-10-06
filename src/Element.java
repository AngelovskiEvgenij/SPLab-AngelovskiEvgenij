public interface Element {
    void print();

    // Implementari implicite pentru frunze: nu pot avea copii
    default void add(Element element) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " nu poate contine alte elemente");
    }

    default void remove(Element element) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " nu poate contine alte elemente");
    }

    default Element get(int index) {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " nu poate contine alte elemente");
    }
}