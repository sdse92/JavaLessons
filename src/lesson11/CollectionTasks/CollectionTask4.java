package lesson11.CollectionTasks;

import java.util.ArrayList;
import java.util.Scanner;

/*
Ввести с клавиатуры 5 слов в список строк.
Удалить 3 - ий элемент списка, и вывести оставшиеся элементы в обратном порядке.
 */
public class CollectionTask4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++){
            list.add(sc.nextLine());
        }
        list.remove(2);
        String mas[] = list.toArray(new String[list.size()]);
        for (int i = mas.length-1; i >= 0; i--){
            System.out.print(mas[i] + " ");
        }
    }
}
