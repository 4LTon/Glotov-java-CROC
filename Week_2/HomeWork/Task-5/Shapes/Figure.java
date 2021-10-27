package Shapes;

public abstract class Figure{
    private final String shapeType;

    public Figure(String shapeType) {
        this.shapeType = shapeType;
    }

    public String getShapeType() {
        return shapeType;
    }

    public abstract boolean pointInShape(int x, int y);

    public abstract void move(int x, int y);
}
