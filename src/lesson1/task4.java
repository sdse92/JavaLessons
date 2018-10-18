package lesson1;
/*
Вывести в консоль ближайшее к 10 из двух чисел, записанных в переменные m и n.
Например, среди чисел 8.5 и 11.45 ближайшее к десяти 11.45.
Метод Math.abs(n) возвращает абсолютное значение числа (модуль числа).
*/
public class task4 {
    public static void main(String[] args) {
        float m = 14.56F;
        float n = -9.45F;
        if (Math.abs(m) - 10 < Math.abs(n) - 10)
            System.out.println("Ближайшее к 10 число m = " + m);
        else
            System.out.println("Ближайшее к 10 число n = " + n);
    }
}
