package lesson11.Task2;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Greg", 3, 6, 4);
        Cat cat2 = new Cat("Luke", 2, 4, 6);

        if (cat1.fight(cat2) == true){
            System.out.println("победил " + cat1.getName());
        }else{
            System.out.println("победил " + cat2.getName());
        }

    }
}
