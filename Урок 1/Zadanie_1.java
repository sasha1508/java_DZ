import java.util.Scanner;

/**
 * Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */
public class Zadanie_1 {

    public static void main(String[] args) {
        clearScreen();
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введи число n: ");
        int n = Integer.parseInt(iScanner.next());
        iScanner.close();

        int triangular = 0;
        int fact = 1;

        for(int i = 1; i <= n; i++){
            triangular += i;
            fact *= i;
                    
        }
        System.out.println("Треугольное число: " + Integer.toString(triangular));
        System.out.println("Факториал: " + Integer.toString(fact));
    }

    // Очистка консоли:
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}