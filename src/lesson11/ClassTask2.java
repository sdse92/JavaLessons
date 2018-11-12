package lesson11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Создать множество чисел(Set<Integer>)
//занести туда 10 различных чисел
//Удалить из множества все числа больше 10
public class ClassTask2 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++){
            set.add((int)(Math.random() * 100));
        }

        System.out.print(set);
        System.out.println();

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            if (iterator.next()>10){
                iterator.remove();
            }
        }
        System.out.print(set);
    }
}
