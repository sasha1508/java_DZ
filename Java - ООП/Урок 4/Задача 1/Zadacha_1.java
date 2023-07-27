/**
 * Задача 1 : Напишите обобщенный метод printElement, который принимает один параметр типа T и выводит его на консоль.

В этом примере мы объявляем обобщенный метод printElement, который принимает один параметр типа T. 
Мы просто выводим этот элемент на консоль с помощью метода System.out.println().

В методе main мы вызываем printElement с различными типами данных: целое число (Integer), 
строку (String) и число с плавающей запятой (Double). 
Компилятор автоматически выводит тип параметра T на основе переданных аргументов.

Таким образом, обобщенные методы позволяют нам писать код, 
который может работать с различными типами данных, обеспечивая простоту и гибкость использования.
 */
public class Zadacha_1 <T>{

    public static void main (String[] args) {
        clearScreen();

        int x = 5;
        String a = "AAAA";
        Double b = 23.45;

        InnerZadacha_1<Integer> item1 = new InnerZadacha_1<Integer>();
        InnerZadacha_1<String> item2 = new InnerZadacha_1<String>();
        InnerZadacha_1<Double> item3 = new InnerZadacha_1<Double>();

        item1.printElement(x);
        item2.printElement(a);
        item3.printElement(b);

    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


class InnerZadacha_1 <T>{

    public void printElement(T t){
        System.out.println(t);
    }
}