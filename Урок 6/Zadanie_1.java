// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.

// Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Zadanie_1 {

    public static void main(String[] args) {
        clearScreen();

        List<Noutbook> noutbooks = new ArrayList<>();

        noutbooks.add(new Noutbook(256, 1024, "Windows", "Black"));
        noutbooks.add(new Noutbook(1024, 512, "Windows", "White"));
        noutbooks.add(new Noutbook(256, 2000, "Windows", "Black"));
        noutbooks.add(new Noutbook(128, 1024, "Windows", "Red"));
        noutbooks.add(new Noutbook(3000, 512, "Windows", "White"));

        System.out.println("Список всех ноутбуков: ");
        for (Noutbook noutbook : noutbooks) {
            noutbook.println();
        }
        System.out.println("");


        System.out.println("Фильтр (введи соответствующую цифру):");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - объём жёсткого диска");
        System.out.println("3 - операционная система");
        System.out.println("4 - цвет");
        
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введи число: ");
        int n = Integer.parseInt(iScanner.next());
        

        if(n == 1){
            System.out.printf("Введи минимальный размер ОЗУ: ");
            int OZU = Integer.parseInt(iScanner.next());

             for (Noutbook noutbook : noutbooks) {
                if(noutbook.OZU >= OZU) noutbook.println();
             }
        }

        if(n == 2){
            System.out.printf("Введи минимальный размер жёсткого диска: ");
            int HDD = Integer.parseInt(iScanner.next());

             for (Noutbook noutbook : noutbooks) {
                if(noutbook.HDD_size >= HDD) noutbook.println();
             }
        }

        if(n == 3){
            System.out.printf("Введи название ОС: ");
            String OS = iScanner.next();

             for (Noutbook noutbook : noutbooks) {
                if(noutbook.OperationSystem.equals(OS)) noutbook.println();
             }
        }

        if(n == 4){
            System.out.printf("Введи цвет ноутбука: ");
            String color = iScanner.next();

             for (Noutbook noutbook : noutbooks) {
                if(noutbook.color.equals(color)) noutbook.println();
             }
        }

        iScanner.close();
        System.out.println("");
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

class Noutbook {
    int OZU;
    int HDD_size;
    String OperationSystem;
    String color;

    public Noutbook(int OZU, int HDD_size, String OperationSystem, String color) {
        this.OZU = OZU;
        this.HDD_size = HDD_size;
        this.OperationSystem = OperationSystem;
        this.color = color;
    }

    public void println() {
        System.out.print("Ноутбук- ");
        System.out.print("ОЗУ: ");
        System.out.print(this.OZU);
        System.out.print(", HDD: ");
        System.out.print(this.HDD_size);
        System.out.print(", операционная система: ");
        System.out.print(this.OperationSystem);
        System.out.print(", цвет: ");
        System.out.print(this.color);
        System.out.println("");
    }
}
