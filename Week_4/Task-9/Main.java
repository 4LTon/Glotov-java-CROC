import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Directory dir;

    public static List<String> lines; // список строк
    public static List<BufferedReader> readerList; // список буферов каждого лог-файла

    public static void main(String[] args) {
        String path = args[0];
        dir = new Directory(path);

        try {
            margeSortLogs();
            showTheListOfLogs();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // считывание всех строк в один список
    public static void margeSortLogs() throws IOException {
        readerList = dir.readersToDir();
        lines = new ArrayList<>();
        List<Long> times = new ArrayList<>(readerList.size()); // список времени сравниваемых строк
        List<String> msgs = new ArrayList<>(readerList.size()); // массив сообщений сравниваемых строк

        // стартовое заполнение списков times и msgs
        for (BufferedReader reader : readerList) {
            String line = reader.readLine();
            times.add(Long.parseLong(line.substring(0, line.indexOf(' '))));
            msgs.add(line.substring(line.indexOf(' ')));
        }

        // сортировка слиянием
        while (true) {
            Long earlyTime = null;
            String earlyMsg = null;
            int pos=0;

            for (int i = 0; i < readerList.size(); i++) { // выберем лог с минимальным временем записи
                if (times.get(i) == null) continue;

                if (earlyTime == null) { // начальное присваивание
                    earlyTime = times.get(i);
                    earlyMsg = msgs.get(i);
                    pos = i;
                    continue;
                }

                if (times.get(i) < earlyTime) { // если встретили время раньше
                    earlyTime = times.get(i);
                    earlyMsg = msgs.get(i);
                    pos = i;
                }
            }

            if (earlyTime == null) break; // логов больше нет

            lines.add(earlyTime + " " + earlyMsg); // запись самого раннего лога

            newLine(readerList.get(pos), times, msgs, pos); // заменяем ранний лог на новый
        }
    }

   // метод считывающий новую строчку
    private static void newLine(BufferedReader buffer, List<Long> times, List<String> msgs, int index) {
        try {
            String line = buffer.readLine();
            if (line == null) {
                times.set(index, null);
                msgs.set(index, null);
            } else {
                times.set(index, Long.parseLong(line.substring(0, line.indexOf(' '))));
                msgs.set(index, line.substring(line.indexOf(' ')));
            }
        } catch (IOException e) {
            e.printStackTrace();
            times.set(index, null);
            msgs.set(index, null);
        }
    }

    // вывести список MAIN.log
    public static void showTheListOfLogs() {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void addListToMainLog() {

    }
}