package lesson4.Task1;

public class Rectangle {
    private int x1;
    private int x2;
    private int x3;
    private int x4;
    private int y1;
    private int y2;
    private int y3;
    private int y4;

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public void setY4(int y4) {
        this.y4 = y4;
    }

    private int ab, ad, S, P;
    public void rectangleParam(Rectangle rectangle){
        if(rectangle.y1 != rectangle.y2 && rectangle.x3 != rectangle.x4) System.out.println("это не прямоугольник");
        ab = rectangle.y2 - rectangle.y1;
        ad = rectangle.x4 - rectangle.x1;
        S = ab * ad;
        P = 2 * (ab + ad);
    }
    public void showRecParam(){
        System.out.println("Площадь прямоугольника: " + S);
        System.out.println("Периметр прямоугольника: " + P);
    }
}
