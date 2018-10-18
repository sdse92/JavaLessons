package lesson1;
/*
Найдите площадь овального кольца, полученного из овала площадью 15 дм2 вырезанием овала площадью 600 см2.
*/
public class task3 {
    public static void main(String[] args) {
        int sOval1 = 1500;
        int sOval2 = 600;
        int sOval3 = sOval1 - sOval2;
        System.out.println("Площадь овального кольца " + sOval3 + " см2");
    }
}
