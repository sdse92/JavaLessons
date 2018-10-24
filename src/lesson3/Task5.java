package lesson3;

import java.util.Arrays;
import java.util.Scanner;

/*1) Найти в строке указанную подстроку и заменить ее на новую.
Строку, ее подстроку для замены и новую подстроку вводит пользователь. */
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку ");
        String a = sc.nextLine();
//        System.out.println("Введите подстроку, которую нужно заменить ");
//        String b = sc.nextLine();
//        System.out.println("Введите подстроку, которую нужно вписать");
//        String c = sc.nextLine();
//        a = a.replace(b, c);
        System.out.println(a);
/*
        Требуется удалить из нее повторяющиеся символы и все пробелы.
        Например, если было введено "abc cde def", то должно быть выведено "abcdef".
*/
        a = a.replaceAll("\\s+","");
        StringBuffer strBuf = new StringBuffer(a);
        for(int i = 0; i < strBuf.length(); i++){
            char n = strBuf.charAt(i);
            for(int j = 1; j < strBuf.length();j++){
                if(strBuf.charAt(j) == n){
                    strBuf.deleteCharAt(j);
                }
            }
        }
        a = strBuf.toString();
        System.out.println(a);
    }
}
