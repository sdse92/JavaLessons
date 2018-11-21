package lesson11.SintaxTasks;
/*
Создать класс с методом getInstance(), который возвращает один и тот же экземпляр данного класса. Создание объектов извне запретить!
 */
class Instance{

    private static Instance instance;

    private Instance() {
    }

    public static synchronized Instance getInstance(){
        if (instance == null){
            return instance = new Instance();
        }else
            return instance;
    }
}

public class Task6 {
    public static void main(String[] args) {
        Instance i = Instance.getInstance();
        System.out.println(i);
        Instance j = Instance.getInstance();
        System.out.println(j);
    }
}
