package lesson2;
/*Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 …. */
public class Task3 {
    public static void main(String[] args) {
        int n = 2;
        for (int i = 1; i <= 20; i++){
            System.out.println(n);
            n = n * 2;
        }
    }
}
