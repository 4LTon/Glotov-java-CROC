public class Annotation {
    private final String signature;
    private final Figure figure;

    public Annotation(int x1, int y1, int x2, int y2, String signature) {
        this.figure = new Figure(x1, y1, x2, y2);
        this.signature = signature;
    }
    public Annotation(int x0, int y0, int radius, String signature) {
        this.figure = new Figure(x0, y0, radius);
        this.signature = signature;
    }

    @Override
    public String toString() {
        return figure + ": " + signature;
    }
}
