public class Circle {
    private int radius;
    private int centerPointX;
    private int centerPointY;

    public Circle(int centerPointX, int centerPointY, int radius) {
        this.centerPointX = centerPointX;
        this.centerPointY = centerPointY;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "(" + centerPointX + ", " + centerPointY + ") " + radius;
    }
}
