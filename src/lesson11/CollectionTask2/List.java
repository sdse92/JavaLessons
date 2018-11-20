package lesson11.CollectionTask2;

import java.util.ArrayList;
import java.util.Scanner;

/*
Написать программу со следующим функционалом:
Считывание 20 чисел с клавиатуры,
сохранение их в список,
сортировка по трём другим спискам:
число нацело делится на 3,
нацело делится на 2 и
все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.

Метод printList() должен выводить на экран все элементы всех списков с новой строки.
Метод printList(String listName) должен выводить на экран все элементы указанного списка
 */
public class List {

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();

    public void put(String s){
            list.add(Integer.parseInt(s));
            if (Integer.parseInt(s)%3 == 0) list1.add(Integer.parseInt(s));
            else if (Integer.parseInt(s)%2 == 0) list2.add(Integer.parseInt(s));
            else list3.add(Integer.parseInt(s));
    }

    public void printList(){
        System.out.println(list);
    }

    public void printList(String name){
        System.out.println(name.toString());
    }
}
