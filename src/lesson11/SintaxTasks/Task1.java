package lesson11.SintaxTasks;

import java.util.Scanner;
/*
Написать следующую программу:
1. Программа должна считывать строки с клавиатуры.
и прекращать считывать данные после того как была введена строка "exit".
2. Если введенная строка содержит точку(".") и может быть корректно преобразована в число типа Double -
должен быть вызван метод print(Double value).
3. Если введенная строка может быть корректно преобразована в число типа short и полученное число больше 0,
но меньше 128 - должен быть вызван метод print(short value).
4. Если введенная строка может быть корректно преобразована в число типа Integer
и полученное число меньше или равно 0 или больше или равно 128 - должен быть вызван метод print(Integer value).
5. Во всех остальных случаях должен быть вызван метод print(String value).
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (true){
            try {
                s = sc.nextLine();
                if (s.equals("exit")) break;
                else if (s.contains(".")) print(Double.parseDouble(s));
                else if (Short.parseShort(s) > 0 && Short.parseShort(s) < 128) print(Short.parseShort(s));
                else if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) >= 128) print(Integer.parseInt(s));
            }catch (NumberFormatException e){
                print(s);
            }
        }
    }
    public static void print(String value){
        System.out.println(value);
    }
    public static void print(Double value){
        System.out.println("Double " + value);
    }
    public static void print(short value){
        System.out.println("short " + value);
    }
    public static void print(Integer value){
        System.out.println("Integer " + value);
    }
}
