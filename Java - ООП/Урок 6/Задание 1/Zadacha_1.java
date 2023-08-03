// Взять реализованный код в рамках семинара 3 , 4 или 5 и продемонстрировать применение принципов, усвоенных на семинаре.
// Нужно в проекте прокомментировать участки кода, которые рефакторим, какой принцип применяем и почему.


import java.util.Scanner;

public class Zadacha_1 {
    public static void main(String[] args) {
        clearScreen();
        Model pribavleniye = new Pribavleniye();
        Model otnimaniye = new Otnimaniye();
        Model umnojeniye = new Umnojeniye();
        Model deleniye = new Deleniye();
        View view = new View();
        Presenter presenter = new Presenter(pribavleniye, otnimaniye, umnojeniye, deleniye, view);
        presenter.calculate();
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

// Принцип "1" - каждому классу свое назначение (арифметические операции),
// Принцип "2" - открытость для расширения (легко добавить новый класс с новой операцией),
// Принцип "3" - наследуемые методы не нарушают работу программы:
abstract class Model {
    public abstract double operation(double x, double y);
}

class Pribavleniye extends Model {
    @Override
    public double operation(double x, double y){
        return x + y;
    }
}
    
class Otnimaniye extends Model {
    @Override
    public double operation(double x, double y){
        return x - y;
    }
}
    
class Umnojeniye extends Model {
    public double operation(double x, double y){
        return x * y;
    }
}
    
class Deleniye extends Model {
    public double operation(double x, double y){
        return x / y;
    }
}
    



// Принцип "1" - каждому классу свое назначение (ввод данных):
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
        System.out.print("Введите операцию (+, -, *, /): ");
        return in.next().charAt(0);
    }
}

// Принцип "1" - каждому классу свое назначение (соединение вводи и вывода):
class Presenter {
    private Model operation1;
    private Model operation2;
    private Model operation3;
    private Model operation4;
    private View view;

    public Presenter(Model operation1, Model operation2, Model operation3, Model operation4, View view){
        this.operation1 = operation1;
        this.operation2 = operation2;
        this.operation3 = operation3;
        this.operation4 = operation4;
        this.view = view;
    }

    
    public void calculate(){
        double x = view.userInput();
        double y = view.userInput();
        char ch = view.operation();
        double result = 0;

        switch (ch) {
            case '+':
                result = operation1.operation(x, y);
                break;
            case '-':
                result = operation2.operation(x, y);
                break;
            case '*':
                result = operation3.operation(x, y);
                break;
            case '/':
                result = operation4.operation(x, y);
                break;
        
            default:
                System.out.println("Введена неверная операция.");
                break;
        }

        view.showOutput(result);
    }
    
}