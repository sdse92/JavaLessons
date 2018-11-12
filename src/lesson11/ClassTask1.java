package lesson11;

//Ввести с клавиатры 5 слов в список строк.
//Удалить 3 -ий элемент
//и вывести оставшиеся элементы в обратном порядке

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassTask1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5);
        Scanner sc = new Scanner(System.in);
        list.add(sc.nextLine());
        list.add(sc.nextLine());
        list.add(sc.nextLine());
        list.add(sc.nextLine());
        list.add(sc.nextLine());

        for (String s: list){
            System.out.print(s + " ");
        }

        System.out.println();

        list.remove(2);

        for (int i = list.size() - 1;i >= 0; i-- ){
            System.out.println(list.get(i));
        }
    }
}
