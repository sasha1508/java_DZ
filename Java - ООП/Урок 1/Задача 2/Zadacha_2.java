// Задача 2:
// Реализуйте класс "Прямоугольник" (Rectangle), который имеет свойства ширина (width) и высота (height). 
// Класс должен обладать следующими методами:

// Конструктор без параметров, который создает прямоугольник с шириной и высотой по умолчанию.
// Конструктор, который принимает значения ширины и высоты и создает прямоугольник с заданными значениями.
// Методы доступа (геттеры и сеттеры) для свойств ширины и высоты.
// Метод "вычислить площадь" (calculateArea), который возвращает площадь прямоугольника (ширина * высота).
// Метод "вычислить периметр" (calculatePerimeter), который возвращает периметр прямоугольника (2 * (ширина + высота)).

public class Zadacha_2 {
    public static void main(String[] args) {
        clearScreen();

        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(200, 300);

        System.out.print("Размеры первого прямоугольника: ");
        System.out.print(rectangle1.GetWidth());
        System.out.print(" x ");
        System.out.print(rectangle1.GetHeight());
        System.out.print(". Площадь = ");
        System.out.print(rectangle1.CalculateArea());
        System.out.print(". Периметр = ");
        System.out.println(rectangle1.CalculatePerimeter());

        rectangle1.SetWidth(110);
        rectangle1.SetHeight(60);
        System.out.print("Новые размеры первого прямоугольника: ");
        System.out.print(rectangle1.GetWidth());
        System.out.print(" x ");
        System.out.print(rectangle1.GetHeight());
        System.out.print(". Площадь = ");
        System.out.print(rectangle1.CalculateArea());
        System.out.print(". Периметр = ");
        System.out.println(rectangle1.CalculatePerimeter());

        System.out.print("Размеры второго прямоугольника: ");
        System.out.print(rectangle2.GetWidth());
        System.out.print(" x ");
        System.out.print(rectangle2.GetHeight());
        System.out.print(". Площадь = ");
        System.out.print(rectangle2.CalculateArea());
        System.out.print(". Периметр = ");
        System.out.println(rectangle2.CalculatePerimeter());
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


class Rectangle {
    private int width;
    private int height;

    Rectangle(){
        this.width = 100;
        this.height = 50;
    }

    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int GetWidth(){
        return width;
    }

    public int GetHeight(){
        return height;
    }

    public void SetWidth(int width){
        this.width = width;
    }

    public void SetHeight(int height){
        this.height = height;
    }

    public int CalculateArea(){
        return width * height;
    }

    public int CalculatePerimeter(){
        return width * 2 + height * 2;
    }

}