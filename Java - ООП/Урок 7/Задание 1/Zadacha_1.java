// Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и деление).
// Применить при создании программы архитектурные паттерны, добавить логирование калькулятора.
// Соблюдать принципы SOLID, паттерны проектирования.



import java.util.Scanner;
import java.util.logging.*;

public class Zadacha_1 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Zadanie_2.class.getName());
        logger.setLevel(Level.INFO);

        clearScreen();
        Model pribavleniye = new Pribavleniye();
        Model umnojeniye = new Umnojeniye();
        Model deleniye = new Deleniye();
        View inputReal = new InputReal();
        View inputImaginary = new InputImaginary();
        View inputOperation = new InputOperation();
        View output = new Output();

        Presenter presenter = new Presenter(pribavleniye, umnojeniye, deleniye, inputReal, 
            inputImaginary, inputOperation, output);
        presenter.calculate();
        logger.info("Vipolnena operaciya vichisleniya");
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
    public abstract String operation(double xReal, double xImaginar, double yReal, double yImaginary);
}

class Pribavleniye extends Model {
    @Override
    public String operation(double xReal, double xImaginar, double yReal, double yImaginary){
        Double imaginary = xImaginar + yImaginary;
        if(imaginary >= 0){
            return String.valueOf(xReal + yReal) + "+" + String.valueOf(imaginary) + "i";
        }
        else{
            return String.valueOf(xReal + yReal) + String.valueOf(imaginary) + "i";
        }
    }
}
    
class Umnojeniye extends Model {
    @Override
    public String operation(double xReal, double xImaginar, double yReal, double yImaginary){
        Double imaginary = xReal * yImaginary + xImaginar * yReal;
        if(imaginary >= 0){
            return String.valueOf(xReal * yReal - xImaginar * yImaginary)  + "+" + String.valueOf(imaginary) + "i";
        }
        else{
            return String.valueOf(xReal * yReal - xImaginar * yImaginary)  + String.valueOf(imaginary) + "i";
        }
    }
}
    
class Deleniye extends Model {
    @Override
    public String operation(double a, double b, double c, double d){
        if(c*c+d*d != 0){
            Double imaginary = (b*c-a*d)/(c*c+d*d);
            if(imaginary >= 0){
                String otvet = String.valueOf((a*c + b*d) / (c*c + d*d)) + "+" + String.valueOf(imaginary) + "i";
                return otvet;
            }
            else{
                String otvet = String.valueOf((a*c + b*d) / (c*c + d*d)) + String.valueOf(imaginary) + "i";
                return otvet;
            }
        }
        return "Деление невозможно";
    }
}
    



// Принцип "1" - каждому классу свое назначение (ввод данных):
class View {
    Scanner in = new Scanner(System.in);

    public double userInput() { return 0; }
    public char operation() { return ' '; } 
    public void showOutput(String value) {}
}

class InputReal extends View{
    @Override
    public double userInput(){
        System.out.print("Введите действительную часть числа: ");
        return in.nextDouble();
    }
}

class InputImaginary extends View{
    @Override
    public double userInput(){
        System.out.print("Введите мнимую часть числа: ");
        return in.nextDouble();
    }
}

class InputOperation extends View{
    @Override
    public char operation(){
        System.out.print("Введите операцию (+, *, /): ");
        return in.next().charAt(0);
    }
    
}

class Output extends View {
    @Override
    public void showOutput(String value){
        System.out.print("Результат: " + value);
        System.out.println("");
        System.out.println("");
    }
    
}



// Принцип "1" - каждому классу свое назначение (соединение ввод и вывода):
class Presenter {
    private Model operation1;
    private Model operation3;
    private Model operation4;
    private View inputReal;
    private View inputImaginary;
    private View inputOperation;
    private View output;

    public Presenter(Model operation1, Model operation3, Model operation4, View inputReal, 
            View inputImaginary, View inputOperation, View output){
        this.operation1 = operation1;  //сложение
        this.operation3 = operation3;  //умножение
        this.operation4 = operation4;  //деление
        this.inputReal = inputReal;
        this.inputImaginary = inputImaginary;
        this.inputOperation = inputOperation;
        this.output = output;
    }

    
    public void calculate(){
        double xReal = inputReal.userInput();
        double xImaginary = inputImaginary.userInput();
        double yReal = inputReal.userInput();
        double yImaginary = inputImaginary.userInput();
        char ch = inputOperation.operation();
        String result = "";

        switch (ch) {
            case '+':
                result = operation1.operation(xReal, xImaginary, yReal, yImaginary);
                break;

            case '*':
                result = operation3.operation(xReal, xImaginary, yReal, yImaginary);
                break;
            case '/':
                result = operation4.operation(xReal, xImaginary, yReal, yImaginary);
                break;
        
            default:
                System.out.println("Введена неверная операция.");
                break;
        }

        output.showOutput(result);
    }
    
}