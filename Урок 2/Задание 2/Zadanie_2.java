// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.util.Arrays;
import java.util.logging.*;

public class Zadanie_2 {
    public static void main(String[] args) {
        clearScreen();

        int[] mas = { 11, 3, 14, 16, 7 };

        Logger logger = Logger.getLogger(Zadanie_2.class.getName());
        logger.setLevel(Level.INFO);
       

        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;

                    logger.info("Sortiruem: i=" + String.valueOf(i) + " " + Arrays.toString(mas));
                }

            }
        }
        System.out.println(Arrays.toString(mas));
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
