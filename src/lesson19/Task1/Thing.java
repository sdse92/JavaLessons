package lesson19.Task1;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Thing {
    private String name;
    private String description;
    private int size;
    @Exclude private boolean taken = false;

    public Thing(String name, String description, int size) {
        this.name = name;
        this.description = description;
        this.size = size;
    }

    public void takeThis(){
        taken = true;
    }

    public String whoAreyou(){
        return "I am " + name;
    }

    @Override
    public String toString() {
        return "Object{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", taken=" + taken +
                '}';
    }

    public static String toString(Object o) {
        Class ob = o.getClass();
        StringBuilder sb = new StringBuilder();
        Field[] declaratedFields = ob.getDeclaredFields();
        for (Field f : declaratedFields){
            try {
                Field field = ob.getDeclaredField(f.getName());
                field.setAccessible(true);
                sb.append(f.getName() + "= " + field.get(o) + ", ");
//                System.out.println(f.getName() + "= " + field.get(o));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        String string = sb.toString();
        return string;
    }
}