// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Zadanie_1 {
    public static void main(String[] args) {
        clearScreen();

        Deque<Integer> deque1 = new LinkedList <Integer>();
        deque1.addFirst(1);
        deque1.addFirst(2);
        deque1.addFirst(3);
       

        Deque<Integer> deque2 = new LinkedList <Integer>();
        deque2.addFirst(2);
        deque2.addFirst(2);
        deque2.addFirst(3);
        deque2.addFirst(3);

        Deque<Integer> dequeTemp = new LinkedList <Integer>();


        System.out.println(deque1);
        System.out.println(deque2);


        dequeTemp = deque1;
        int chislo1 = 0;
        int i = 1;
        while (true) {
            var chislo = dequeTemp.pollFirst();
            if(chislo == null) {break;}
            else{
            chislo1 += chislo * i;
            i *= 10;}
        }

        dequeTemp = deque2;
        int chislo2 = 0;
        i = 1;
        while (true) {
            var chislo = dequeTemp.pollFirst();
            if(chislo == null) {break;}
            else{
            chislo2 += chislo * i;
            i *= 10;
            }
        }
        System.out.println(chislo1);
        System.out.println(chislo2);
        

        int chislo3 = chislo1 * chislo2;

        System.out.print("* ");
        System.out.println(chislo3);

        Deque<Integer> deque3 = new LinkedList <Integer>();
        i = 10;
        while(true){
            int chislo = chislo3 % i;
            if(chislo == 0) break;
            deque3.addLast(chislo);
            chislo3 /= 10;
        }

        System.out.println(deque3);
    }

     // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
