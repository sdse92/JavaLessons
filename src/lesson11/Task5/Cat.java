package lesson11.Task5;

public class Cat implements Eat, Eatable, Movable {

    @Override
    public void eat() {
        System.out.println("I can eat");
    }

    @Override
    public void eatable() {
        System.out.println("I can be eaten");
    }

    @Override
    public void movable() {
        System.out.println("I can move");
    }
}
