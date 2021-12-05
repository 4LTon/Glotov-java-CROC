package Recommend;

import java.util.*;

public class Recommend {

    /** Метод, возвращающий рекомендацию по просмотрам пользователя **/
    public static String getRecommend(String views) {
        User mainUser = new User(views);
        List<User> userList = GetFiles.listOfUserViews();

        userList = selectUsers(mainUser, userList);

        List<Integer> moviesForRecommend = getMoviesForRecommend(mainUser, userList);

        int ID = getRecommendMovie(moviesForRecommend); // ID рекомендуемого фильма

        return GetFiles.moviesToHashMap().get(ID);
    }

    /** Метод, возвращающий пользователей которые смотрели те же фильмы, что и выбранный пользователь
     * mainUser - пользователь для которого составляется рекоммендация**/
    private static List<User> selectUsers(User mainUser, List<User> usersList) {

        List<User> usersWatchedTheSameMovies = new ArrayList<>();

        for (User user : usersList) {
            if (compareUsers(mainUser, user)) {
                usersWatchedTheSameMovies.add(user);
            }
        }

        return usersWatchedTheSameMovies;
    }

    /** Метод, сравнивающий двух пользователей
     * true - половина просмотров совпадает
     * false - половина просмотров не совпадает **/
    private static boolean compareUsers(User firsUser, User secondUser) {
        String[] firstUserMovies = firsUser.toString().split(",");
        String[] secondUserMovies = secondUser.toString().split(",");

        Set<String> sameMovies = new HashSet<>();

        for (String firstUserMovie : firstUserMovies) {
            for (String secondUserMovie : secondUserMovies) {
                if (firstUserMovie.equals(secondUserMovie)) sameMovies.add(secondUserMovie);
            }
        }

        return (firstUserMovies.length / 2) <= sameMovies.size();
    }

    /** Метод, возвращающий список фильмов для дальнейшей рекомендации **/
    private static List<Integer> getMoviesForRecommend(User mainUser, List<User> selectedUsers) {
        List<Integer> moviesForRecommend = new ArrayList<>();

        for (User user : selectedUsers) {
            String[] views = user.toString().split(",");
            for (String view : views) {
                moviesForRecommend.add(Integer.parseInt(view));
            }
        }

        removeViewedMovies(mainUser, moviesForRecommend);

        return moviesForRecommend;
    }

    /** Метод, удаляющий фильмы, которые уже были просмотренны пользователем **/
    private static List<Integer> removeViewedMovies(User mainUser, List<Integer> moviesForRecommend) {
        String[] viewedMovies = mainUser.toString().split(",");

        for (String movie : viewedMovies) {
            Integer movieIndex = Integer.parseInt(movie);

            // если фильм содержится в списке, то он удаляется из рекоммендации
            int i;
            while ((i = moviesForRecommend.indexOf(movieIndex)) != -1) {
                moviesForRecommend.remove(i);
            }
        }

        return moviesForRecommend;
    }

    /** Находим фильм для рекоммендации **/
    public static int getRecommendMovie(List<Integer> moviesForRecommend) {

        // находим самый часто встречающийся id фильма
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;    // максимальное количество упоминаний фильма в истории просмотров
        int recommendID = -1;   // ID фильма для рекоммендации

        for (Integer id : moviesForRecommend) {
            if (hm.get(id) != null) {
                int count = hm.get(id);
                ++count;
                hm.put(id, count);

                if (count > max) {
                    recommendID = id;
                    max = count;
                }
            } else {
                hm.put(id, 1);
            }
        }

        // так как фильмы в файле индексируются начиная с 1, а в Recommend.GetFiles.moviesToHashMap() с 0
        // конечный ID уменьшается на единицу
        return recommendID - 1;
    }
}