package lesson24.Task1_Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Visiter visiter1 = new Visiter();
        Book b1 = new Book("one", true);
        library.put(b1);
        Book b2 = new Book("two", false);
        library.put(b2);
        Book b3 = new Book("three", false);
        library.put(b3);
        Book b4 = new Book("four", true);
        library.put(b4);
        Book b5 = new Book("five", false);
        library.put(b5);
        library.show();
        visiter1.getBook("two");
        visiter1.getBook("five");
        visiter1.show();
    }
}
