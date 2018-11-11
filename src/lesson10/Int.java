package lesson10;

public class Int {

    public static void someVoid2() {
        int a = 12;
    }

    public static void someVoid(){
        int a = 90;
        someVoid2();
    }

    public static void main(String[] args) {
        someVoid();
    }
    //Serial GC - сборщик мусора
    //Parallel GC Java 8 - появился в 8 Java
    //G1 Java 9
    //параллельный G1 Java 10
    //ZGC Java 11
}
