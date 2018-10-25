package lesson4.Task1;

public class Triangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    private double a, b, c, S, P;
    public void triangParam(Triangle triangle){
        a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        b = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        c = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        double halfP = (a + b + c) / 2.0;
        S = Math.sqrt(halfP * (halfP - a) * (halfP - b) * (halfP - c));
        P = a + b + c;
    }
    public void showTriParam(){
        System.out.println("Площадь треугольника: " + S);
        System.out.println("Периметр треугольника: " + P);
    }
}
