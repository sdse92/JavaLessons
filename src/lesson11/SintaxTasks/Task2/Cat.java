package lesson11.SintaxTasks.Task2;
/*
Создать класс Cat.
У кота должно быть имя (name, String),
возраст (age, int),
вес (weight, int),
сила (strength, int).
 */
public class Cat {
    String name;
    int age;
    int weight;
    int strength;

    public Cat(String name, int age, int weight, int strength) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public boolean fight(Cat anotherCat){
        if (anotherCat.age < this.age && anotherCat.strength > this.strength) return false;
        else if (anotherCat.weight < this.weight && anotherCat.strength > this.strength) return false;
        else    return true;
    }

    public String getName() {
        return name;
    }
}
