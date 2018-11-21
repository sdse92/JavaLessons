package lesson11.SintaxTasks.Task5;

public class Mouse implements Movable, Eatable {
    @Override
    public void eatable() {
        System.out.println("I can be eaten");
    }

    @Override
    public void movable() {
        System.out.println("I can move");
    }
}
