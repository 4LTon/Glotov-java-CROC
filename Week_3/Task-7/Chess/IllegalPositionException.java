package Chess;

public class IllegalPositionException extends Exception{

    public IllegalPositionException(int x, int y) {
        super("������������ ������ ��������� �������: " + Character.toString('a' + x) + (y + 1));
    }
}
