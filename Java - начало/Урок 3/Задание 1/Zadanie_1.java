// Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Zadanie_1
 */
public class Zadanie_1 {

    public static void main(String[] args) {
        clearScreen();

        ArrayList<Integer> list1 = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            list1.add((int) (Math.random() * 100));
        }

        System.out.print("Исходный массив: ");
        System.out.println(list1);

        for (int i = 9; i >= 0; i--) {
            if ((list1.get(i) % 2) == 0) {
                list1.remove(i);
            }
        }

        System.out.print("Удалены все чётные числа: ");
        System.out.println(list1);

        System.out.print("Максимальное значение: ");
        System.out.println(Collections.max(list1));

        System.out.print("Минимальное значение: ");
        System.out.println(Collections.min(list1));

        if (list1.size() > 0) {
            double sum = 0;
            for (int item : list1) {
                sum += item;
            }
            double average = sum / list1.size();

            System.out.print("Среднее значение: ");
            System.out.println(average);
        }
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}