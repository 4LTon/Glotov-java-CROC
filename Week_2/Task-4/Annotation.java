import Shapes.Circle;
import Shapes.Figure;
import Shapes.Rectangle;

public class Annotation {
    private final String signature;
    private final Figure figure;

    public Annotation(int x0, int y0, int radius, String signature) {
        this.signature = signature;
        figure = new Circle(x0, y0, radius);
    }

    public Annotation(int x0, int y0, int x1, int y1, String signature) {
        this.signature = signature;
        figure = new Rectangle(x0, y0, x1, y1);
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return figure + ": " + signature;
    }
}
