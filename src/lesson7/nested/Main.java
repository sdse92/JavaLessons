package lesson7.nested;

public class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("Объект outerClass");

        outerClass.getInner().someVoid();

        System.out.println(OuterClass.intVar);

    }
}
