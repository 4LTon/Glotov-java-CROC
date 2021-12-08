import java.util.*;

public class Main {

    private static final List<Respondent> respondents = new ArrayList<>();
    private static final List<Integer> groups = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Считываем и создаем список возрастных групп
        String strGroups = in.nextLine();
        for (String group : strGroups.split(" ")) {
            groups.add(Integer.parseInt(group));
        }

        // Записываем данные респондентов
        String input;
        while (true) {
            input = in.nextLine();
            if (input.equals("END")) break;
            String[] data = input.split(",");
            respondents.add(new Respondent(data[0], Integer.parseInt(data[1])));
        }

        // Создаем TreeMap, где ключ - предльная возрастная граница одной группы, значение - Set респондентов
        TreeMap<Integer, ArrayList<Respondent>> split = new TreeMap<>();
        for (Respondent respondent : respondents) {
            Integer key = getGroup(respondent.getAge());
            try {
                split.get(key).add(respondent);
            }
            catch (Exception e) {
                split.put(key, new ArrayList<>(List.of(respondent)));
            }

        }
        sortGroups(split);
        showResult(split);
    }

    // Метод находит возрастную группу к которой относится респондент
    private static int getGroup(int age) {
        for (int group : groups) {
            if (age <= group) return group;
        }
        return groups.get(groups.size() - 1);
    }

    // Сортируем каждый список по возрасту
    private static void sortGroups(TreeMap<Integer, ArrayList<Respondent>> split) {
        for (int key : split.keySet()) {
            split.get(key).sort(Respondent::compareTo);
        }
    }

    // Выводит результат
    public static void showResult(TreeMap<Integer, ArrayList<Respondent>> split) {
        for (int i = groups.size() - 1; i <= 0; i--) {
            
        }
    }
}