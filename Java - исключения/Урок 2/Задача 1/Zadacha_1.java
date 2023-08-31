//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Zadacha_1 {
    public static void main(String[] args) {
        clearScreen();
        boolean inputNubmer = false;
        float number = 0;

        while (!inputNubmer) {
            try {
                number = Input();
                inputNubmer = true;
            } catch (Exception e) {

            }
        }
        System.out.println(number);
    }

    public static float Input(){

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        float result =  in.nextFloat();
        in.close();
        
        return result;
    }

     // Очистка консоли:
     public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}