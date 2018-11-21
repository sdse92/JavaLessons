package lesson11.SintaxTasks;

import java.util.Scanner;

/*
Ввести с клавиатуры два целых числа, которые будут координатами точки, не лежащей на координатных осях OX и OY.
Вывести на экран номер координатной четверти, в которой находится данная точка.

Принадлежность точки с координатами (a,b) к одной из четвертей определяется следующим образом:
для первой четверти a>0 и b>0;
для второй четверти a<0 и b>0;
для третьей четверти a<0 и b<0;
для четвертой четверти a>0 и b<0.
Пример для чисел 4 6: 1
Пример для чисел -6 -6: 3
 */
public class moreTask2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координату точки а");
        int a = sc.nextInt();
        System.out.println("Введите координату точки b");
        int b = sc.nextInt();
        System.out.print("Точка лежит в четверти ");
        if (a > 0 && b > 0) {
            System.out.println(1);
        }else if (a < 0 && b > 0){
            System.out.println(2);
        }else if (a < 0 && b < 0){
            System.out.println(3);
        }else if (a > 0 && b < 0){
            System.out.println(4);
        }
    }
}
