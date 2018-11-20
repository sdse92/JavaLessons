package lesson11.CollectionTask1;

import java.util.ArrayList;
import java.util.Scanner;

/*
Написать программу со следующим функционалом:
Считывание максимум 5 строк с клавиатуры,
занесение строк в список,
поиск самой короткой строки,
вывод самой короткой строки на экран по запросу пользователя (команда в консоле /short string)
Если одинаково коротких строк несколько, выводить каждую с новой строки.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minValue = Integer.MAX_VALUE;
        int counter = 0;
        ArrayList<String> ar = new ArrayList<>();
        while (true){
                String s = sc.nextLine();
                if (s.equals("/short string")) {
                    for (String string : ar) {
                        if (minValue == string.length()) System.out.println(string);
                    }
                }
                if (counter >= 5){
                    System.out.println("В списке не может быть больше 5 лементов");
                    break;
                }
                ar.add(s);
                if (s.length() < minValue) minValue = s.length();
                counter++;
        }


    }

}
