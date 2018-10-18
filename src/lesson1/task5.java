package lesson1;
/*
Задать размер ипотечного кредита , процентную ставку , кол-во лет .
Найти переплату по кредиту, значение переплаты вывести в консоль.
*/
public class task5 {
    public static void main(String[] args) {
        int credit = 2000000;
        double percent = 0.17;
        int time = 25;
        double pereplata = (credit * percent) * 25;
        System.out.println("Переплата = " + pereplata);
    }
}
