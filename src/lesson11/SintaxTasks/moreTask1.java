package lesson11.SintaxTasks;
/*
Написать метод, который определяет, объект какого класса ему передали,
и выводит на экран одну из надписей: Кошка, Собака, Птица.
 */
public class moreTask1 {
    public static void main(String[] args) {
        objectType(new Cat());
        objectType(new Dog());
        objectType(new Bird());
    }

    public static void objectType(Object o){
        if (o instanceof Cat){ System.out.println("Кошка");}
        if (o instanceof Dog){ System.out.println("Сообака");}
        if (o instanceof Bird){ System.out.println("Птица");}
    }

    public static class Cat{}
    public static class Dog{}
    public static class Bird{}
}
