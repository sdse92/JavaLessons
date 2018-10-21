package lesson2;
/*Проверьте, является ли натуральное число — простым.*/
public class Task4 {
    public static void main(String[] args) {
        int n = 3;
        int i;
        boolean notSimple = false;
        for (i = 2; i < n; i++) {
            if (n % i == 0) {
                notSimple = true;
                break;
            }
        }
        if (notSimple) {
            System.out.println("число составное ");
        } else {
            System.out.println("число  простое ");
        }
    }
}
