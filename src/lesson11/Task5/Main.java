package lesson11.Task5;
/*
Создать классы Dog, Cat и Mouse.
Реализовать интерфейсы (Movable, Eatable, Eat ) в классах, учитывая что:
- Кот может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь может передвигаться и может быть съедена.
- Собака может передвигаться и съесть кого-то.
 */
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Mouse mouse = new Mouse();
        dog.eat();
        dog.movable();
        cat.eatable();
        cat.eat();
        cat.movable();
        mouse.eatable();
        mouse.movable();
    }
}
