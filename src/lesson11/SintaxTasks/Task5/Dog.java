package lesson11.SintaxTasks.Task5;

public class Dog implements Movable, Eat {
    @Override
    public void eat() {
        System.out.println("I can eat");
    }

    @Override
    public void movable() {
        System.out.println("I can move");
    }
}
