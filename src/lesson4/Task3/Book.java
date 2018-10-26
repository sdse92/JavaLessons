package lesson4.Task3;

public class Book {
    private String name;
    private int n;

    public void setName(String name) {
        this.name = name;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", n=" + n +
                '}';
    }
}
