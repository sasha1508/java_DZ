// Задача 2 : Напишите обобщенный метод printArray, который принимает массив любого типа и выводит его элементы на консоль.
// В этом примере мы объявляем обобщенный метод printArray, 
//который принимает массив типа T. Затем мы используем цикл for-each, чтобы пройти по всем элементам массива и вывести их на консоль.

// В методе main мы создаем массивы типов Integer и String и вызываем printArray для каждого из них. 
//В результате мы получаем вывод на консоль элементов каждого массива.

// Таким образом, обобщенные методы позволяют нам создавать код, 
//который может работать с разными типами данных, обеспечивая повторное использование и гибкость.

import java.util.Arrays;

public class Zadacha_2 {
    public static void main(String[] args) {
        clearScreen();

        Integer[] array1 = new Integer[] {5, 6, 4 ,2 ,3};
        String[] array2 = new String[] {"Один", "Два", "Три", "Четыре", "Пять"};

        InnerZadacha_2<Integer> item1 = new InnerZadacha_2<Integer>();
        InnerZadacha_2<String> item2 = new InnerZadacha_2<String>();

        item1.printArray(array1);
        item2.printArray(array2);
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

 class InnerZadacha_2 <T>{

    public void printArray(T[] array){
        System.out.println(Arrays.toString(array));
    }
}