package lesson11.SintaxTasks.Task3;
/*
Создать класс Dog с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет (имя, адрес и возраст неизвестны, это бездомный пес)
- вес, цвет, адрес (домашний пес)

Задача конструктора – сделать объект валидным.
 */
public class Dog {
    String name;
    int weight;
    int age;
    String color;
    String adress;
    static int count;

    public Dog(String name) {
        this.name = name;
        this.weight = 15;
        this.age = 3;
        this.color = "Brown";
        this.adress = "Street";
        count++;
    }

    public Dog(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "Brown";
        this.adress = "Street";
        count++;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.weight = 15;
        this.age = age;
        this.color = "Brown";
        this.adress = "Street";
        count++;
    }

    public Dog(int weight, String color) {
        this.name = "Sharik";
        this.weight = weight;
        this.age = 3;
        this.color = color;
        this.adress = "Street";
        count++;
    }

    public Dog(int weight, String color, String adress) {
        this.name = "Sharik";
        this.weight = weight;
        this.age = 3;
        this.color = color;
        this.adress = adress;
        count++;
    }

    public int getDogCount(){
        return count;
    }
}
