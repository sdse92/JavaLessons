package lesson3;

import java.util.Scanner;

/*Пользователь должен указать с клавиатуры чётное положительное число,
а программа должна создать массив указанного размера из случайных целых чисел из [-5;5] и вывести его на экран в строку.
После этого программа должна определить и сообщить пользователю о том, сумма модулей какой половины массива больше:
левой или правой, либо сообщить, что эти суммы модулей равны. Если пользователь введёт неподходящее число,
то программа должна требовать повторного ввода до тех пор, пока не будет указано корректное значение.
*/
public class Task4 {
    public static void main(String[] args) {
        int a,leftSum=0,rightSum=0;
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите четное число");
        if (scn.hasNextInt()){
            do{
                a=scn.nextInt();
                if(a%2!=0||a<1)System.out.println("Вы ошиблись, введите повторно четное число!");
            }
            while(a%2!=0||a<1);
            int[] Mas = new int[a];
            for(int i=0;i<Mas.length;i++){
                Mas[i]=(int)(Math.random()*11)-5;
                System.out.print(Mas[i]+" ");
                if(i<=Mas.length/2-1){
                    leftSum+=Math.abs(Mas[i]);
                }
                else {
                    rightSum+=Math.abs(Mas[i]);
                }
                if(i==Mas.length-1){
                    System.out.println(" ");
                    if(leftSum>rightSum)
                        System.out.println("Сумма модулей первой половины массива больше и равна ");
                    if(rightSum>leftSum)
                        System.out.println("Сумма модулей второй половины массива больше и равна ");
                    if(rightSum==leftSum)
                        System.out.println("Суммы модулей первой и второй половины равны");
                }
            }
        }
        else System.out.println("Введено не число");
    }
}

