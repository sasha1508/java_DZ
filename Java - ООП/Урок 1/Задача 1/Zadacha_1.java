// Задача 1:
// Создайте класс "Кот" (Cat) со следующими свойствами:

// Приватное поле "имя" (name) типа String для хранения имени кота.
// Приватное поле "возраст" (age) типа int для хранения возраста кота.
// Публичные методы доступа (геттеры и сеттеры) для полей "имя" и "возраст".
// Публичный метод "приветствие" (greet), который выводит на консоль приветствие вида "Мяу! Меня зовут <имя>. Мне <возраст> года(лет).".

// Дополнительное задание:
// Создайте класс "Владелец" (Owner) со свойством "имя" (name) типа String. 
// Добавьте соответствующее поле в классе "Кот" и методы доступа для него. 
// Измените метод "приветствие" класса "Кот", чтобы он выводил приветствие вида "Мяу! Меня зовут <имя>. Мне <возраст> года(лет). 
// Мой владелец - <имя владельца>.".

/**
 * Zadacha_1
 */
public class Zadacha_1 {

    public static void main(String[] args) {
        clearScreen();

        Owner vladelets1 = new Owner("Иван Иваныч");
        Owner vladelets2 = new Owner("Александр Сергеевич Пушкин");
        Owner vladelets3 = new Owner("Воланд");
        Owner vladelets4 = new Owner("Маркиз де Карабас");

        Cat Cat1 = new Cat("Мурзик", 2, vladelets1);
        Cat Cat2 = new Cat("Учёный", 300, vladelets2);
        Cat Cat3 = new Cat("Бегемот", 2000, vladelets3);
        Cat Cat4 = new Cat("Кот в сапогах", 331, vladelets4);

        Cat1.greet();
        Cat2.greet();
        Cat3.greet();
        Cat4.greet();

        System.out.println("");
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

/**
 * InnerZadacha_1
 */
class Cat {
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

}

class Owner {
    String name;
    
    Owner(String name){
        this.name = name;
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