package lesson7.anonimys;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc(3, 1);
        calc.summ(new Operation() {
            @Override
            public double apply(double var1, double var2) {
                return var1 + var2;
            }
        });


    }
}
