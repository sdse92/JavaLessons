package lesson6.battleunit;

public interface ISpeakerUnit {



    void say(String text);
    void sing(String song);

    default void greeteng(){
        // default метод с реализацией
        System.out.println("Hello");
    }
}
