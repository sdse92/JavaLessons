package lesson7.anonimys;

import lesson7.anonimys.Operation;

public class Calc {
    int a;
    int b;
    public Calc(int a, int b){
        this.a = a;
        this.b = b;
    }

    public double summ(Operation operation){
        return operation.apply(a, b);
    }
}
