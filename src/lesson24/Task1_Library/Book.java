package lesson24.Task1_Library;

public class Book {
    private String name;
    private boolean local;

    public Book(String name, boolean local) {
        this.name = name;
        this.local = local;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", local=" + local +
                '}';
    }
}
