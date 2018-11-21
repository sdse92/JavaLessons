package lesson11.SintaxTasks.Task4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите вес: ");
            double weight = sc.nextDouble();
            System.out.println("Введите рост: ");
            double heigh = sc.nextDouble();

            Body.index(weight, heigh);
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }
}
