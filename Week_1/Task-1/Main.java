import java.util.Scanner;

public class Main {
    static class Point {
        double x;
        double y;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Point a = new Point();
        System.out.print("Введите координату х вершины №1: ");
        a.x = in.nextDouble();
        System.out.print("Введите координату y вершины №1: ");
        a.y = in.nextDouble();

        Point b = new Point();
        System.out.print("Введите координату х вершины №2: ");
        b.x = in.nextDouble();
        System.out.print("Введите координату y вершины №2: ");
        b.y = in.nextDouble();

        Point c = new Point();
        System.out.print("Введите координату х вершины №3: ");
        c.x = in.nextDouble();
        System.out.print("Введите координату y вершины №3: ");
        c.y = in.nextDouble();

        double area = 0.5 * Math.abs((b.x - a.x)*(c.y - a.y) - (c.x - a.x)*(b.y - a.y));

        System.out.println("Площадь треугольника: " + area);
    }
}
