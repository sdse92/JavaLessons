package lesson11.Task4;

public class Body {

    static Double weight;
    static Double heigh;


    public static void index(double weight, double heigh){
        Double q = weight/(heigh*heigh);
        if (q < 18.5) System.out.println("Недовес: меньше чем 18.5");
        else if (18.5 < q && q < 24.9) System.out.println("Нормальный: между 18.5 и 24.9");
        else if (25 < q && q < 29.9) System.out.println("Избыточный: между 25 и 29.9");
        else if (q > 30) System.out.println("Ожирение: 30 или больше");
    }
}
