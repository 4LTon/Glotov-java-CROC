package Chess;

public class IllegalPositionException extends Exception{

    public IllegalPositionException(int x, int y) {
        super("Некорректный формат введенной позиции: " + Character.toString('a' + x) + (y + 1));
    }
}
