// Реализовать простой калькулятор

import java.util.Scanner;

public class Zadanie_3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        String key ="";
        while(true){
            clearScreen();
            

            System.out.printf("Введи первое число: ");
            Double x = Double.parseDouble(iScanner.next());

            System.out.printf("Введи второе число: ");
            Double y = Double.parseDouble(iScanner.next());

            System.out.printf("Введи операцию (Q-выход): ");
            key = iScanner.next();
            

            if(key.equals("+")){
                System.out.println("Ответ: " + Double.toString(x + y));
            }
            else if(key.equals("-")){
                System.out.println("Ответ: " + Double.toString(x - y));
            }
            else if(key.equals("*")){
                System.out.println("Ответ: " + Double.toString(x * y));
            }
            else if(key.equals("/")){
                System.out.println("Ответ: " + Double.toString(x / y));
            }
            else if(key.equals("q") || key.equals("Q")){
                break;
            }
            else {
                System.out.println("Введена неподдерживаемая операция");
            }
            
            System.out.println("Любой символ - продолжить (Q-выход)");
            key = iScanner.next();
            if(key.equals("q") || key.equals("Q")){
                break;
            }
        }
        iScanner.close();
    }

    // Очистка консоли:
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
