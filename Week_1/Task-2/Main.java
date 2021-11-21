import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println(printBytes(in.nextLong()));
    }

    public static String printBytes(long bytes) {
        // Приставки для размерности
        String[] prefix = new String[] {"", "K", "M", "G", "T"};

        /*
         * Для определения подходящей приставки используется рекурсивный счетчик
         * Он определяет сколько раз вводимое число можно поделить на 1024
         */
        int countForPrefix = getCount(bytes);

        // Формирование выводимого числа
        double result = getCount(bytes) == 0 ? bytes : bytes / (Math.pow(2,10 * countForPrefix);

        return String.format("%.1f", result) + " " + prefix[countForPrefix] + "B";
    }

    // Рекурсивный счетчик
    private static int getCount(long bytes) {
        if (bytes / 1024 >= 1) {
            return getCount(bytes / 1024) + 1;
        }
        return 0;
    }
}
