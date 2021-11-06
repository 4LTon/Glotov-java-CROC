package Shapes;

public class Rectangle extends Figure implements Movable{
    private int x0;
    private int y0;
    private int x1;
    private int y1;

    public Rectangle(int x0, int y0, int x1, int y1) {
        super("R");
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public String toString() {
        return getShapeType() + " (" + x0 + ", " + y0 + "), (" + x1+ ", " + y1 + ")";
    }

    @Override
    public boolean pointInShape(int x, int y) {
        return (x0 <= x && x <= x1) && (y0 <= y && y <= y1);
    }

    @Override
    public void move(int dx, int dy) {
        this.x0 = x0 + dx;
        this.x1 = x1 + dx;
        this.y0 = y0 + dy;
        this.y1 = y1 + dy;
    }
}
