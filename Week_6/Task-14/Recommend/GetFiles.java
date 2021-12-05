package Recommend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetFiles {
    /** Используемые ссылки **/
    private static final Path LISTS = Path.of("C:\\Users\\A026\\Desktop\\Vlad\\out\\production\\KROK\\Recommend\\lists");
    private static final Path VIEWING_HISTORY_FILE = Path.of(LISTS + "\\" + "ViewingHistory");
    private static final Path LIST_OF_MOVIES_FILE = Path.of(LISTS + "\\" + "ListOfMovies");

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

    /** Создаем список просмотров пользователей на основе файла с историями просмотров **/
    public static List<User> listOfUserViews() {

        List<User> views = new ArrayList<>();

        try {
            for (String line : Files.readAllLines(VIEWING_HISTORY_FILE)) {
                views.add(new User(line));
            }

        } catch (IOException e) {
            System.out.println("Не удалось считать файл: " + VIEWING_HISTORY_FILE);
        }

        return views;
    }
}