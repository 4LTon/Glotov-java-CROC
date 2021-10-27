package Shapes;

public class Circle extends Figure{

    private int x0;
    private int y0;
    private final int radius;

    public Circle(int x0, int y0, int radius) {
        super("C");
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return getShapeType() + " (" + x0 + ", " + y0 + "), " + radius;
    }
}
