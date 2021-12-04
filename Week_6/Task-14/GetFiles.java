import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetFiles {
    /** Используемые ссылки **/
    private static final Path LISTS = Path.of("C:\\Users\\A026\\Desktop\\Vlad\\out\\production\\KROK\\lists");
    private static final Path VIEWING_HISTORY_FILE = Path.of(LISTS + "\\" + "ViewingHistory");
    private static final Path LIST_OF_MOVIES_FILE = Path.of(LISTS + "\\" + "ListOfMovies");

    /** Вспомогательные переменные **/
    private static final byte maxNumberLength = 2; // длина максимального порядкового номера фильма

    /** Создаем HashMap на основе файла с названиями фильмов **/
    public static HashMap<Integer, String> moviesToHashMap() {

        HashMap<Integer, String> movies = new HashMap<>();
        int i = 0;

        try {
            for (String movie : Files.readAllLines(LIST_OF_MOVIES_FILE)) {
                movies.put(i, movie.split(",")[1]);
                ++i;
            }
        } catch (IOException e) {
            System.out.println("Не удалось считать файл: " + LIST_OF_MOVIES_FILE);
        }

        return movies;
    }

    /** Создаем List на основе файла с историями просмотров **/
    public static List<Integer> viewsList() {

        List<Integer> views = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(VIEWING_HISTORY_FILE.toString())) {

            // Буффер для записи цифр в формате char для дальнейшего перевода их в число типа int
            // Так как мы знаем что
            StringBuilder num = new StringBuilder(maxNumberLength);

            int i;
            while ((i = file.read()) != -1) {
                char digit = (char) i;
                if ((digit != ',') && (digit != '\n')) {
                    num.append(digit);
                } else {
                    views.add(Integer.parseInt(num.toString()));
                    num.delete(0,maxNumberLength);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Не удалось считать файл: " + VIEWING_HISTORY_FILE);
        }

        return views;
    }
}