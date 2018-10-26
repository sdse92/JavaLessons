package lesson4.Task3;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setName("b1");

        Library lib = new Library();
        lib.put(book1, 3);
        lib.put(book1, 1);
        lib.showLib();
    }
}
