import Recommend.Recommend;

public class Main {
    public static void main(String[] args) {
        String views = "2,5,11,23";  // args[0]

        // Ожидаемый результат: "Отверженные"
        System.out.println(Recommend.getRecommend(views));
    }
}