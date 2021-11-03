package Chess;

public class ChessPosition {
    private final int x;
    private final int y;

    public ChessPosition(int x, int y) throws IllegalPositionException{
        if (0 > x || x > 7 || 0 > y || y > 7) throw new IllegalPositionException(x, y);
        else {
            this.x = x;
            this.y = y;
        }
    }

    // разбиение строки позиции на координаты
    public static ChessPosition parse(String position) throws IllegalPositionException {
        return new ChessPosition(position.charAt(0) - 'a', position.charAt(1) - '0' - 1);
    }

    // проверка возможности прохождения маршрута
    public static boolean checkMove(ChessPosition[] chessPositions) throws IllegalMoveException{
        for (int i = 1; i < chessPositions.length; ++i) {
            if (!chessPositions[i - 1].checkTwo(chessPositions[i])) {
                throw new IllegalMoveException(chessPositions[i - 1], chessPositions[i]);
            }
        }
        return true;
    }

    // проверка, можно ли перейти из одной точки в следующую
    public boolean checkTwo(ChessPosition chessPositions) throws IllegalMoveException{
        if ((Math.abs(this.x - chessPositions.x) == 1 && Math.abs(this.y - chessPositions.y) == 2)
                || (Math.abs(this.x - chessPositions.x) == 2) && Math.abs(this.y - chessPositions.y) == 1) {
            return true;
        } else
            throw new IllegalMoveException(this, chessPositions);
    }

    @Override
    public String toString() {
        return Character.toString('a' + this.x) + (this.y + 1);
    }
}