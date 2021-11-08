import java.io.*;

public class Main {
    public static void main(String[] args){
        File file = new File(args[0]);
        int count = 0;
        // Параметр CHECK проверят, стоит ли пробел перед буквенным символом или нет
        // Стартовое значение TRUE, это позволяет учесть наличие пробелов перед началом первого слова в тексте
        boolean check = true;

        try(Reader reader = new InputStreamReader(new FileInputStream(file))) {
            int a;
            while ((a = reader.read()) != -1) {
                // Определяем, является ли код считанного символа кодом буквенного символа
                if ((65 <= a && a <= 90) || (97 <= a && a <= 122) || (1040 <= a && a <= 1103)) {
                    if (check) {
                        ++count;
                        check = false;
                    }
                } else check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}