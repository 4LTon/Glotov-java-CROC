import Chess.*;

import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static ChessPosition[] chessPositions;

    public static void main(String[] args) {
        try {
            chessPositions = input(in.nextLine());
            if (move()) {
                System.out.println("��");
            }
        } catch (IllegalPositionException | IllegalMoveException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("It's not my Error.\n" + ex.getMessage());
        }
    }

    // ����� ����� ����������
    public static ChessPosition[] input(String args) throws IllegalPositionException {
        String[] positions = args.split(" ");

        ChessPosition[] chessPositions = new ChessPosition[positions.length];

        for (int i = 0; i < positions.length; i++) {
            chessPositions[i] = ChessPosition.parse(positions[i]);
        }

        return chessPositions;
    }

    // ����� �������� ��������
    public static boolean move() throws IllegalMoveException {
        return ChessPosition.checkMove(chessPositions);
    }
}