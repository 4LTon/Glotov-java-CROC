public class Figure {
    private String shapeType;
    private Rectangle rectParams;
    private Circle crclParams;

    // Определить параметры фигуры
    public Figure(int x0, int y0, int radius) {
        crclParams = new Circle(x0, y0, radius);
        shapeType = "C";
    }

    public Figure(int x1, int y1, int x2, int y2) {
        rectParams = new Rectangle(x1, y1, x2, y2);
        shapeType = "R";
    }

    public String getShapeType() {
        return this.shapeType;
    }

    @Override
    public String toString() {
        if (shapeType.equalsIgnoreCase("R")) {
            return shapeType + " " + rectParams;
        } else {
            return shapeType + " " + crclParams;
        }
    }
}
