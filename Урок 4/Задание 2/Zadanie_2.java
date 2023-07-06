// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.

// 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными.


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Zadanie_2 {
    public static void main(String[] args) {
        clearScreen();

        Deque<Integer> deque1 = new LinkedList <Integer>();
        deque1.addFirst(1);
        deque1.addFirst(2);
        deque1.addFirst(-3);
       
        Deque<Integer> deque2 = new LinkedList <Integer>();
        deque2.addFirst(2);
        deque2.addFirst(2);
        deque2.addFirst(3);
        deque2.addFirst(-3);

        Deque<Integer> dequeTemp = new LinkedList <Integer>();

        System.out.println(deque1);
        System.out.println(deque2);

        dequeTemp = deque1;
        int chislo1 = 0;
        int i = 1;
        int znak = 1;
        while (true) {
            int chislo;
            try{
            chislo = dequeTemp.pollFirst();
            }
            catch(Exception ex){
                break;
            }

            if(chislo < 0){
                chislo *= -1;
                znak *= -1;
            }

            chislo1 += chislo * i;
            i *= 10;}

        chislo1 = chislo1 * znak;

        dequeTemp = deque2;
        int chislo2 = 0;
        i = 1;
        znak = 1;
        while (true) {
            int chislo;
            try{
            chislo = dequeTemp.pollFirst();
            }
            catch(Exception ex){
                break;
            }

            if(chislo < 0){
                chislo *= -1;
                znak *= -1;
            }

            chislo2 += chislo * i;
            i *= 10;}

        chislo2 = chislo2 * znak;


        System.out.println(chislo1);
        System.out.println(chislo2);
        

        int chislo3 = chislo1 + chislo2;

        System.out.print("Сумма: ");
        System.out.println(chislo3);

        Deque<Integer> deque3 = new LinkedList <Integer>();
        i = 10;
        while(true){
            int chislo = chislo3 % i;
            if(chislo3 == 0) break;
            deque3.addLast(chislo);
            chislo3 /= 10;
            if(chislo3 < 0) chislo3 *= -1;
        }

        System.out.println(deque3);
    }

     // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
