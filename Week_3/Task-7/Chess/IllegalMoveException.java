package Chess;

public class IllegalMoveException extends Exception {

    public IllegalMoveException(ChessPosition first, ChessPosition second) {
        super("���� ��� �� �����: " + first + " -> " + second);
    }
}
