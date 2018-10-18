package lesson1;
/*
На садовом участке площадью 10 соток , разбили грядки 15 на 25 метров. Сколько м2 осталось незанято?
*/
public class task2 {
    public static void main(String[] args) {
        int sUchastka = 1000;
        int gradkaLength = 15;
        int gradkaTall = 25;
        int sGradka = gradkaTall * gradkaLength;
        sUchastka = sUchastka - sGradka;
        System.out.println("Осталось " + sUchastka + " свободных м2");
    }
}
