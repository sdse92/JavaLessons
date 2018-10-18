package lesson1;
/*
Задайте высоту, длину и ширину прямоугольного параллелепипеда и найти его площадь.
Узнайте, что больше: ширина или высота и выведите информацию об этом в консоль.
*/

public class task1 {
    public static void main(String[] args) {
        int high = 4;
        int length = 6;
        int tall = 2;
        int S = 2*(high*length + high*tall + length*tall);
        System.out.println("Площадь = " + S);
        if (high > length && high > tall)
            System.out.println("Высота больше длинны и ширины");
        else if (length > high && length > tall)
            System.out.println("Длинна больше высоты и ширины");
        else
            System.out.println("Ширина больше высоты и длинны");
    }
}
