package lesson19.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //каждый загруженный класс имеет соответствующий java.lang.Class объект, который дает доступ к структуре класса
        //У каждого типа есть свой литерал
        System.out.println(String.class);
        System.out.println(int.class);

        Child child = new Child("x", 2);
        //строковый литерал объекта
        System.out.println(child.getClass());
        //строковый литерал класса наследника

        Class cls;
        cls = child.getClass();
        System.out.println("child name " + cls.getName());

        cls = cls.getSuperclass();
        System.out.println("child extends" + cls.getName());
        //доступ к компонентам

        //класс объекта
        Class<Child> childClass = Child.class;

        //доступ к полям
        Field[] fields = childClass.getFields();
        System.out.println(Arrays.toString(fields));

        //доступ к declarated полям
        Field[] declaratedFields = childClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaratedFields));

        //доступ к методам
        Method[] methods = childClass.getMethods();
        System.out.println(Arrays.toString(methods));

        //доступ к declared методам
        Method[] declaredMethods = childClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        //доступ к конструкторам
        Constructor<?>[] declaredConstructor = childClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructor));

        //доступ к конкретному полю, методу, конструктору
        Field field = childClass.getDeclaredField("name");
        //получить доступ к полю
        field.setAccessible(true);
        field.set(child, "CHILD");
        System.out.println(field.get(child));
        System.out.println(child);

        //получить доступ к методу
        Method method = childClass.getDeclaredMethod("getInfo");
        method.setAccessible(true);
        String data = (String) method.invoke(child);
        System.out.println(data);

        //доступ к конструктору
        Constructor<Child> childConstructor = childClass.getDeclaredConstructor(String.class, int.class);
        //создание объекта
        Child child1 = childConstructor.newInstance("CHILD1", 3);
        System.out.println(child1);

        boolean isFinal = Modifier.isFinal(field.getModifiers());
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());

        Class<?>[] interfaces = childClass.getInterfaces();



    }
}
