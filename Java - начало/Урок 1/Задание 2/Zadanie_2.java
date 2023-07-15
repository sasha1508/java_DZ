// Вывести все простые числа от 1 до 1000

public class Zadanie_2 {
    public static void main(String[] args) {
        
    for(int i = 1; i < 1000; i++)
        if(Prostoe(i)){
            System.out.printf(Integer.toString(i) + " ,");
        }
    }

    static boolean Prostoe(int chislo){
        for(int j = 2; j < chislo; j++){
            if(chislo % j == 0){
                return false;
            }
        }
        return true;
    }
}
