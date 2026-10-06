public class Context {
    private final int width;

    public Context() {
        this(40);
    }

    public Context(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}