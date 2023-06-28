// Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.

public class Zadanie_1 {

    public static void main(String[] args) {
        clearScreen();

        StringBuilder SQLString = new StringBuilder("select * from students where ");
        StringBuilder filtr = new StringBuilder(
                "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");

        filtr.replace(filtr.indexOf("{"), filtr.indexOf("{") + 1, "");
        filtr.replace(filtr.indexOf("}"), filtr.indexOf("}") + 1, "");

        while (filtr.indexOf("\"") >= 0) {
            filtr.replace(filtr.indexOf("\""), filtr.indexOf("\"") + 1, "");
        }

        while (filtr.indexOf(",") >= 0) {
            String newFiltr = filtr.substring(0, filtr.indexOf(","));
            filtr.delete(0, filtr.indexOf(",") + 2);

            //System.out.println(newFiltr);
            if (newFiltr.substring(newFiltr.indexOf(":") + 1, newFiltr.length()).compareTo("null") != 0) {
                SQLString.append(newFiltr.substring(0, newFiltr.indexOf(":")));
                SQLString.append(" = \"");
                SQLString.append(newFiltr.substring(newFiltr.indexOf(":") + 1, newFiltr.length()));
                SQLString.append("\" and ");
                //System.out.println(SQLString);
            }
        }

        String newFiltr = filtr.substring(0, filtr.length());
        //System.out.println(newFiltr);

        if (newFiltr.substring(newFiltr.indexOf(":") + 1, newFiltr.length()).compareTo("null") != 0) {

            SQLString.append(newFiltr.substring(0, newFiltr.indexOf(":")));
            SQLString.append(" = \"");
            SQLString.append(newFiltr.substring(newFiltr.indexOf(":") + 1, newFiltr.length()));
            SQLString.append("\"");

        } else {
            SQLString.delete(SQLString.length() - 4, SQLString.length());
        }
        System.out.println(SQLString);
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}