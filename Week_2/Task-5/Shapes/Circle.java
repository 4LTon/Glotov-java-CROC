package Shapes;

public class Circle extends Figure implements Movable{

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

    @Override
    public boolean pointInShape(int x, int y) {
        double ownRadius = Math.sqrt(Math.pow(x - x0, 2) + Math.pow(y - x0, 2));
        return ownRadius <= radius;
    }

    @Override
    public void move(int dx, int dy) {
        this.x0 = x0 + dx;
        this.y0 = y0 + dy;
    }
}
