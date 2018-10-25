package lesson4.Task1;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setR(4);
        circle.circleLength(circle);
        circle.showCirLength();

        Rectangle rectangle = new Rectangle();
        rectangle.setX1(0);
        rectangle.setY1(0);
        rectangle.setX2(0);
        rectangle.setY2(2);
        rectangle.setX3(4);
        rectangle.setY3(2);
        rectangle.setX4(4);
        rectangle.setY4(0);
        rectangle.rectangleParam(rectangle);
        rectangle.showRecParam();

        Triangle triangle = new Triangle();
        triangle.setX1(0);
        triangle.setY1(0);
        triangle.setX2(2);
        triangle.setY2(3);
        triangle.setX3(4);
        triangle.setY3(1);
        triangle.triangParam(triangle);
        triangle.showTriParam();
    }
}
