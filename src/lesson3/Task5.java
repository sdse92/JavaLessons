package lesson3;

import java.util.Scanner;

/*1) Найти в строке указанную подстроку и заменить ее на новую.
Строку, ее подстроку для замены и новую подстроку вводит пользователь. */
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку ");
        String a = sc.nextLine();
        System.out.println("Введите подстроку, которую нужно заменить ");
        String b = sc.nextLine();
        System.out.println("Введите подстроку, которую нужно вписать");
        String c = sc.nextLine();
        System.out.println(a.replace(b, c));
/*
        Требуется удалить из нее повторяющиеся символы и все пробелы.
        Например, если было введено "abc cde def", то должно быть выведено "abcdef".
*/
        String [] strArr = {a};
        for (int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            if(ch == a.charAt(i+1)){
                a = a.replace(a.charAt(i+1), "");
            }
        }
    }
}
