package lesson2;
/*
В три переменные a, b и c явно записаны программистом три целых попарно неравных между собой числа.
Создать программу, которая переставит числа в переменных таким образом,
чтобы при выводе на экран последовательность a, b и c оказалась строго возрастающей.
*/
public class Task1 {
    public static void main(String[] args) {
        int a = 7;
        int b = 0;
        int c = -5;
        int d;
        while (a > b || b > c){
            if (a > b) {
                d = a;
                a = b;
                b = d;
            }
            if (b > c) {
                d = b;
                b = c;
                c = d;
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
}
