// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.HashMap;
import java.util.Map;

/**
 * Zadanie_1
 */
public class Zadanie_1 {

    public static void main(String[] args) {
        clearScreen();

        Map<String, String> db = new HashMap<>();
        db.put("+79115254512", "Иванов И.И.");
        db.put("+79424234553", "Иванов И.И.");
        db.put("+79866793432", "Петров И.И.");
        db.put("+79865486214", "Петров И.И.");
        db.put("+79869852354", "Петров И.И.");
        db.put("+79591651664", "Ленин В.И.");
        db.put("+79135462584", "Крупская Н.К.");
        
        System.out.println(db);
        System.out.println("");

        for (String string : db.keySet()) {
            System.out.println(string + " - " + db.get(string));
        }

        System.out.println(" ");

        // формеруем "Map" для вывода на печать:
        Map<String, String> temp = new HashMap<>();
        String stringTemp = "";
        for (String string : db.keySet()) {
            stringTemp = string;
            if (temp.containsKey(db.get(string))) {
                stringTemp = string + ", " + temp.get(db.get(string));
            }
            temp.put(db.get(string), stringTemp);
        }

        while (temp.size() > 0) {
            String fio = "";
            int count = 0;
            int max = 0;

            // Определяем абонента, у которого больше всего номеров телефонов:
            for (String string : temp.keySet()) {
                count = temp.get(string).split(", ").length;
                if (max < count) {
                    max = count;
                    fio = string;
                }
            }
            System.out.println(fio + " - " + temp.get(fio));
            temp.remove(fio);
        }
        System.out.println("");
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}