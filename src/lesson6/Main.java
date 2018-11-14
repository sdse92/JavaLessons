package lesson6;

import lesson6.battleunit.*;
import lesson6.calculator.Operation;
import lesson6.calculator.Plus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Knight knight = new Knight(100, 20);
//        Spearman spearman = new Spearman(60, 70);
//
//        Doctor doctor = new Doctor(50, 10);
//        doctor.attack(knight);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите название персонажа");
//        String userChoice = scanner.nextLine();
//
//        BatttleUnitFactory unitFactory = new BatttleUnitFactory();
//        BattleUnit unit = unitFactory.create(userChoice);
//
//
//        Fight fight = new Fight(knight, spearman);
//        fight.fight();
//        System.out.println( fight.fightResult());

        int a = 9;
        int b = 1;
        Operation plus = new Plus(a, b);

        System.out.println(plus.execute());

//        Operation minus = new Minus(a, b);
//        minus.execute();
    }
}
