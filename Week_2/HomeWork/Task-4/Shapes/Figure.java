package Shapes;

public abstract class Figure{
    private final String shapeType;

    public Figure(String shapeType) {
        this.shapeType = shapeType;
    }

    public String getShapeType() {
        return shapeType;
    }
}
