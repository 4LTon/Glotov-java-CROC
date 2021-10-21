public class Rectangle {
    private int leftBottomPointX;
    private int leftBottomPointY;
    private int rightTopPointX;
    private int rightTopPointY;

    public Rectangle(int leftBottomPointX, int leftBottomPointY, int rightTopPointX, int rightTopPointY) {
        this.leftBottomPointX = leftBottomPointX;
        this.leftBottomPointY = leftBottomPointY;
        this.rightTopPointX = rightTopPointX;
        this.rightTopPointY = rightTopPointY;
    }

    @Override
    public String toString() {
        return "(" + leftBottomPointX + ", " + leftBottomPointY + "), (" + rightTopPointX + ", " + rightTopPointY + ")";
    }
}
