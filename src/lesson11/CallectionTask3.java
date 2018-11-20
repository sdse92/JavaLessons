package lesson11;

import java.util.ArrayList;
import java.util.Scanner;

/*
Написать программу со следующим функционалом:
 Считывание  с клавиатуры 10 слов в список строк.
 Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
 Метод printList()  должен выводить результат на экран (каждое значение с новой строки).
 */
public class CallectionTask3 {
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> doublelist = new ArrayList<>();

    public static void main(String[] args) {
        CallectionTask3 task = new CallectionTask3();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++){
            task.list.add(sc.nextLine());
        }
        task.doubleValues();
        task.printList();
    }

    void doubleValues(){
        for (String s : list){
            doublelist.add(s);
            doublelist.add(s);
        }
    }

    void printList(){
        for (String s : doublelist)
        System.out.println(s);
    }
}
