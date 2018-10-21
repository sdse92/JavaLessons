package lesson2;
/*Выведите на экран первые 11 членов последовательности Фибоначчи.
Первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих. */
public class Task5 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < 11; i++){
            System.out.println(b);
            c = a + b;
            a = b;
            b = c;
        }
    }
}
