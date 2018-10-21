package lesson2;
/*Электронные часы показывают время в формате от 00:00 до 23:59.
Подсчитать сколько раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация для той,
что справа от двоеточия (например, 02:20, 11:11 или 15:51). */
public class Task7 {
    public static void main(String[] args) {
        int n = 0;
        for (int i = 0; i <= 23; i++){
            for (int j = 0; j <= 59; j++){
                int firstI = i/10;
                int secondI = i%10;
                int firstJ = j/10;
                int secondJ = j%10;
                if (firstI == secondJ && secondI == firstJ){
                    n++;
                }
            }
        }
        System.out.println(n);
    }
}
