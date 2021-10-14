/*
 * При загрузке Main.java возникала ошибка кодировки windows-1252.
 * Данная кодировка ругается на символы кириллицы (в частности на заглавную букву 'и').
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // считывание массива (преобразование элемента из String --> int)
        String input = in.nextLine();
        String[] strArr = input.split(" ");

        // индексы максимального и минимального элементов массива
        int maxIndex = 0;
        int minIndex = 0;

        // преобразование массива (преобразование элемента из String --> int)
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
            // поиск наименьшего и наибольшего элемента в массиве
            if (numArr[minIndex] > numArr[i]) {minIndex = i;}
            else if (numArr[maxIndex] < numArr[i]) {maxIndex = i;}
        }

        // ставится минимальный элемент на первое мест
        int safeValue = numArr[0];
        numArr[0] = numArr[minIndex];
        numArr[minIndex] = safeValue;

        // если максимальное число оказалось на первом месте
        // - то после перестановки минимального числа на первое место его индекс изменится
        if (maxIndex == 0) {maxIndex = minIndex;}

        // ставится максимальный элемент на первое место
        safeValue = numArr[numArr.length - 1];
        numArr[numArr.length - 1] = numArr[maxIndex];
        numArr[maxIndex] = safeValue;

        // преобразование массива (преобразование элемента из int --> String)
        System.out.println(Arrays.toString(numArr));
    }
}
