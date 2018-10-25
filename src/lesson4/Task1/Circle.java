package lesson4.Task1;

public class Circle {
    private int R;

    public void setR(int r) {
        R = r;
    }

    private double cirLength;
    public void circleLength(Circle circle){
        cirLength = Math.PI * 2 * circle.R;
        return;
    }

    public void showCirLength(){
        System.out.println("Длинна окружности: " + cirLength);
    }
}
