package Chess;

public class IllegalMoveException extends Exception {

    public IllegalMoveException(ChessPosition first, ChessPosition second) {
        super("конь так не ходит: " + first + " -> " + second);
    }
}
