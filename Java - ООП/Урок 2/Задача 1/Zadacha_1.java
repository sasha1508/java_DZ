// Добавить пять интерфейсов к классам из ДЗ 1, включающих все концепции, упомянутые на семинаре. включающих:
// - интерфейсы,
// - константы,
// - default методы,
// - перегрузки и переопределения методов.Вы можете выбрать любой класс из ДЗ 1 и добавить к нему интерфейсы. 
// Вам также предоставляется возможность добавить новые методы или использовать уже существующие методы в классе.

public class Zadacha_1 {
    public static void main(String[] args) {
        clearScreen();

        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(200, 300);
        Owner Sergey = new Owner("Сергей");
        Cat murzic = new Cat("Мурзик", 1, Sergey);

        rectangle1.Zhivoy();
        rectangle1.hello();
        PrintInfo(rectangle1);
        rectangle1.perimeter();
        PrintArea(rectangle1);
        rectangle2.Zhivoy();
        rectangle2.hello();
        PrintInfo(rectangle2);
        rectangle2.perimeter();
        PrintArea(rectangle2);
        Sergey.Zhivoy();
        Sergey.hello();
        PrintInfo(Sergey);
        Sergey.perimeter();
        PrintArea(Sergey);
        murzic.Zhivoy();
        murzic.hello();
        PrintInfo(murzic);
        murzic.perimeter();
        PrintArea(murzic);

        System.out.println("");

        System.out.print("Размеры первого прямоугольника: ");
        System.out.print(rectangle1.GetWidth());
        System.out.print(" x ");
        System.out.print(rectangle1.GetHeight());
        System.out.print(". Площадь = ");
        System.out.print(rectangle1.CalculateArea());
        System.out.print(". Периметр = ");
        System.out.println(rectangle1.CalculatePerimeter());

        rectangle1.SetWidth(120);
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

    public static void PrintInfo(Info info){
        info.info();
    }

    public static void PrintArea(Area area){
        System.out.println(" Площадь = " + area.CalculateArea());
    }
}


class Rectangle implements Info, Hello, Area, Zhivoy, Perimeter {

    private final int widthMin = 10;
    private int width;
    private int height;

    Rectangle(){
        this.width = widthMin + 100;
        this.height = 50;
    }

    Rectangle(int width, int height){
        this.width = widthMin + width;
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

    @Override
    public int CalculateArea(){
        return width * height;
    }

    public int CalculatePerimeter(){
        return width * 2 + height * 2;
    }

    @Override
    public void info(){
        System.out.print( "Я прямоугольник " + this.width + "x" + this.height + ". ");
    }

    @Override 
    public void Zhivoy(){
        System.out.print( "Неживой - ");
    }

    @Override
    public void perimeter(){
        System.out.print("Мой периметр = " + this.CalculatePerimeter() + ". ");
    }
}


class Cat implements Info, Hello, Area, Zhivoy, Perimeter{
    private String name;
    private int age;
    private Owner owner;

    Cat (String name, int age, Owner owner){
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public void SetName(String name){
        this.name = name;
    }

    public void SetAge(int age){
        this.age = age;
    }

    public String GetName(){
        return name;
    }

    public int GetAge(){
        return age;
    }

    public void greet(){
        String years = DeclensionGenerator.Generate(age, "год", "года", "лет");
        System.out.println(String.format("Мяу! Меня зовут %s. Мне %s %s. Мой владелец - %s", name, Integer.toString(age), years, owner.name));
    }

    @Override
    public int CalculateArea(){
        return 0;
    }

    @Override
    public void info(){
        System.out.print( "Я кот по кличке " + this.name + ". ");
    }

    @Override 
    public void Zhivoy(){
        System.out.print( "Живой - ");
    }

    @Override
    public void perimeter(){
        System.out.print("Мой периметр бесконечен. ");
    }
}

class Owner implements Info, Hello, Area, Zhivoy, Perimeter{
    String name;
    
    Owner(String name){
        this.name = name;
    }

    @Override
    public int CalculateArea(){
        return 0;
    }

    @Override
    public void info(){
        System.out.print( "Я человек по имени " + this.name + ". ");
    }

    @Override 
    public void Zhivoy(){
        System.out.print( "Живой - ");
    }

    @Override
    public void perimeter(){
        System.out.print("Мой периметр бесконечен. ");
    }
}

class DeclensionGenerator 
    {
        /// <summary>
        /// Возвращает слова в падеже, зависимом от заданного числа
        /// </summary>
        /// <param name="number">Число от которого зависит выбранное слово</param>
        /// <param name="nominativ">Именительный падеж слова. Например "день"</param>
        /// <param name="genetiv">Родительный падеж слова. Например "дня"</param>
        /// <param name="plural">Множественное число слова. Например "дней"</param>
        /// <returns></returns>
        public static String Generate(int number, String nominativ, String genetiv, String plural)
        {
            if(number < 0) { number *= -1; }
            String[] titles = new String[] { nominativ, genetiv, plural };
            int[] cases = new int[] { 2, 0, 1, 1, 1, 2 };
            return titles[number % 100 > 4 && number % 100 < 20 ? 2 : cases[(number % 10 < 5) ? number % 10 : 5]];
        }

        
    }

