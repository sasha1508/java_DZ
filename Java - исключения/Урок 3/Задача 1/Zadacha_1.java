// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол

// Форматы данных:
// фамилия, имя, отчество - строки
// датарождения - строка формата dd.mm.yyyy
// номертелефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.

// Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, 
// вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, 
// пользователю выведено сообщение с информацией, что именно неверно.

// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
// в него в одну строку должны записаться полученные данные, вида

// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

// Не забудьте закрыть соединение с файлом.

// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
// пользователь должен увидеть стектрейс ошибки.

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;



public class Zadacha_1 {
    public static void main(String[] args) throws IOException {
        clearScreen();

        int result = inputData();

        if(result == -1) {System.out.println("Вы ввели меньше данных, чем требуется");}
        else if(result == -2) {System.out.println("Вы ввели больше данных, чем требуется");}
    }

    public static int inputData() throws IOException{
        Gender gender = Gender.UNKNOWN;
        long phone = 0; 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate  date = LocalDate.parse("01.01.0001", formatter);
        String name1 = "";
        String name2 = "";
        String name3 = "";
        int namberOfName = 1;
        
        System.out.print("Введи данные (Фамилия Имя Отчество датарождения номертелефона пол): ");

        BufferedReader in = new BufferedReader(System.console().reader()); //создаём буфер для чтения строки

        String inputString = in.readLine();  //получаем введённую строку
        System.out.println(inputString);

        String[] inputList = inputString.split(" ");  //разделяем исходную строку на части

        if(inputList.length < 6) {return -1;}  //если введено меньше данных, то возвращаем код ошибки
        else if(inputList.length > 6) {return -2;}  //если введено больше данных, то возвращаем код ошибки

        for (String iterable_element : inputList) {
            //Получаем номер телефона:
            try {
                phone = Long.parseLong(iterable_element);
            } catch (Exception e) {
                // TODO: handle exception
            }
            
            //Получаем дату рождения:
            try {
                date = LocalDate.parse(iterable_element, formatter);               
            } catch (Exception e) {
                // TODO: handle exception
            }

            if(iterable_element.equals("f"))  {gender = Gender.FEMALE;}
            else if(iterable_element.equals("m"))  {gender = Gender.MALE;}
            else if(itPhone(iterable_element)) {}
            else if(itDate(iterable_element)) {}
            else if(namberOfName == 1) {name1 = iterable_element; namberOfName++;}
            else if(namberOfName == 2) {name2 = iterable_element; namberOfName++;}
            else if(namberOfName == 3) {name3 = iterable_element; namberOfName++;}
            
            
           // System.out.println(iterable_element);
        }

        //Обрабатываем исключения:
        if(gender == Gender.UNKNOWN)  {throw new RuntimeException("Не получилось распознать пол.");}
        else if(phone == 0)  {throw new RuntimeException("Не получилось распознать номер телефона.");}
        else if(date.isEqual(LocalDate.parse("01.01.0001", formatter)))  {throw new RuntimeException("Не получилось распознать дату рождения.");}

        System.out.println("Пол: " + GenderToString(gender));
        System.out.println("Телефон: " + phone);
        System.out.println("Дата рождения: " + date);
        System.out.println("ФИО: " +  name1 + " " + name2 + " " + name3);

        saveFile(name1, name2, name3, date, formatter, phone, gender);

        return 0;
    }

    //Сохранение файла:
    public static void saveFile(String name1, String name2, String name3, LocalDate date, DateTimeFormatter formatter, long phone, Gender gender) throws IOException{
        String stringToSave = "";
        
        File file = new File( "Java - исключения\\Урок 3\\Задача 1\\" + name1 + ".txt");
        //create the file.
        if (file.createNewFile()){
            System.out.println("Файл создан!");
            String formattedDate = date.format(formatter);
            stringToSave = "<" + name1 + "><" + name2 + "><" + name3 + "><" + formattedDate + "> <" + phone + "><" + GenderToString(gender) + ">";

            //write content
            FileWriter writer = new FileWriter (file);
            writer.write(stringToSave); //<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
            writer.close();
        }
        else{
            System.out.println("Файл уже существует.");
            
            String content = readFile("Java - исключения\\Урок 3\\Задача 1\\" + name1 + ".txt");
            System.out.println("TEST - " + content);

            String formattedDate = date.format(formatter);
            stringToSave = "<" + name1 + "><" + name2 + "><" + name3 + "><" + formattedDate + "> <" + phone + "><" + GenderToString(gender) + ">";

            if(!content.equals(stringToSave)){
                stringToSave = content + "\n" + stringToSave;

                //write content
                FileWriter writer = new FileWriter (file);
                writer.write(stringToSave); //<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
                writer.close();
            }
        }
        
        
    }

    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

    // Очистка консоли:
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public enum Gender{
        MALE,
        FEMALE,
        UNKNOWN
    }

    public static String GenderToString(Gender gender){
        if(gender == Gender.MALE) {return "мужской";}
        if(gender == Gender.FEMALE) {return "женский";}
        return "не определён";
    }

    public static boolean itPhone(String iterable_element){
        //Получаем номер телефона:
        try {
            long phone = Long.parseLong(iterable_element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean itDate(String iterable_element){
        //Получаем дату рождения:
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(iterable_element, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
