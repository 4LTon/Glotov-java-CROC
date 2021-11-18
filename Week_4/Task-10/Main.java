import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Path path = Paths.get(args[0]); // log.txt
            List<String> lines = Files.readAllLines(path);
            List<CallPoint> callPoints = toCallPointList(lines);
            Collections.sort(callPoints); // сортируем точки в порядке возрастания

            int result = Integer.MIN_VALUE;
            int count = 0;

            for (CallPoint point : callPoints) {
                count = (point.isStartOfContact()) ? count + 1 : count - 1;

                result = Math.max(result, count);
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // преобразовываем данные в объекты точек во времени
    public static List<CallPoint> toCallPointList(List<String> lines) {
        List<CallPoint> callPoints = new ArrayList<>();
        for (String line : lines) {
            String[] points = line.split(",");
            CallPoint point1 = new CallPoint(Long.parseLong(points[0]), true);
            CallPoint point2 = new CallPoint(Long.parseLong(points[1]), false);
            callPoints.add(point1);
            callPoints.add(point2);
        }
        return callPoints;
    }
}