package lesson7.Book;

import java.util.Objects;
import java.util.Random;

final public class Book {
    final String CONST; // = "String"

    public Book(String title, String author, String val) {
        this.title = title;
        this.author = author;
        CONST = val;
    }



//    static {
//        CONST = "vlue";
//    }

//    public void changeConst(){
//        CONST = "new Value";
//    }

    private String title;
    private String author;
    private int pages;
    private int soldBook1;

    public static int soldBook;

    static {
        soldBook = -(new Random().nextInt(100));
    }

    final public void sellBook(){
        soldBook++;
        soldBook1++;
    }

    public String getSoldBook1(){
        return  "Book soldBook1: " + soldBook1;
    }

    public static String getStatistic(){
        return "Book sold: " + soldBook;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    // все классы наследуются от Object
    // toString()

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
    //clone() - возвращает копию объекта

    //getClass()
    // finalize()
    //wait() | notify() | notifyAll()

    //equals() - возвращает true или falce
    //по умолчанию объекты сравнивает с помощью ==
    //hashCode() - возвращает hashCode объекта


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, pages);
    }
}
