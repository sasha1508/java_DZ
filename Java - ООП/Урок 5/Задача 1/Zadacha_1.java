// 1 - Конструируем калькулятор, применяя архитектуру MVP (Model-View-Presenter), 
// с возможностью выполнения базовых математических операций, таких как сложение, вычитание, 
// умножение и деление, работающий с дробными числами.
// Доп. Задача (*) Мы также обеспечим обработку возможных ошибок, чтобы предотвратить некорректные операции.

import java.util.Scanner;

public class Zadacha_1 {
    public static void main(String[] args) {
        clearScreen();
        Model model = new Model();
        View view = new View();
        Presenter presenter = new Presenter(model, view);
        presenter.calculate();
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

class Model {

    public double pribavleniye(double x, double y){
        return x + y;
    }

    public double otnimaniye(double x, double y){
        return x - y;
    }

    public double umnojeniye(double x, double y){
        return x * y;
    }

    public double deleniye(double x, double y){
        return x / y;
    }
}

class View {
    Scanner in = new Scanner(System.in);

    public double userInput(){
        System.out.print("Введите число: ");
        return in.nextDouble();
    }

    public void showOutput(double value){
        System.out.print("Результат: " + value);
    }
    
    public char operation(){
        System.out.println("Введите операцию (+, -, *, /): ");
        return in.next().charAt(0);
    }
}

class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void calculate(){
        double x = view.userInput();
        double y = view.userInput();
        char ch = view.operation();
        double result =0;

        switch (ch) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
        
            default:
                System.out.println("Введена неверная операция.");
                break;
        }

        view.showOutput(result);
    }
    
}