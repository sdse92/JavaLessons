package lesson3;

import java.util.Arrays;

/*Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран сначала в строку,
отделяя один элемент от другого пробелом, а затем в столбик (отделяя один элемент от другого началом новой строки).
Перед созданием массива подумайте, какого он будет размера. 2 4 6 … 18 20 2 4 6 … 20 */
public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int n = 0;
        StringBuffer sb1= new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        String s = " ";
        String c = "\n";
        for (int i = 2; i <= 20; i = i + 2) {
            arr[n] = i;
            sb1.append(arr[n]).append(s);
            sb2.append(arr[n]).append(c);
            n++;
            }
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        }
}
