package lesson2;

import java.util.Scanner;

/*Задать количество тарелок и количество моющего средства.
Моющее средство расходуется из расчета 0,5 на одну тарелку.
В цикле выводить сколько моющего средства осталось после мытья каждой тарелки
В конце вывести, сколько тарелок осталось, когда моющее средство закончилось или наоборот.*/
public class Task9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество тарелок ");
        double plateNum = scan.nextInt();
        System.out.println("Введите количество моющего средства ");
        double detergent = scan.nextInt();
        if (detergent > plateNum * 0.5){
            for (double i = plateNum; i > 0; i--){
                detergent = detergent - 0.5;
            }
            System.out.println("Осталось " + detergent + " моющего средства");
        }else{
            for (double i = detergent; i > 0; i = i - 0.5){
                plateNum--;
            }
            System.out.println("Осталось " + plateNum + " тарелок");
        }
    }
}
