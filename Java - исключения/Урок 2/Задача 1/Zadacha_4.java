// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class Zadacha_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        String result =  in.nextLine();
        in.close();

        if(result.length() == 0){
            System.out.println("q");
            throw new RuntimeException("Empty lines cannot be entered.");
        }
    }
}
