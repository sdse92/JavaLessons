package lesson6.calculator;

public class Plus extends Operation{
    public Plus(int a, int b) {
        super(a, b);
    }

    @Override
    public int execute() {
        return this.getA() + this.getB();
    }


}
