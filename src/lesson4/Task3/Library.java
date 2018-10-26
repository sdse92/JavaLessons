package lesson4.Task3;

import java.util.Arrays;

public class Library {
    private int qiantity = 0;
    private int bookNumber = 10;
    private Book [] books = new Book[bookNumber];

    public void put(Book book, int quantity){
        System.out.println(quantity);
        if(qiantity + quantity < bookNumber) {
            for(int i = 0; i < books.length; i++){
                if (books[i] == null) {
                    books[i] = book;
                    System.out.println(books[i]);
                    qiantity++;
                    int a = book.getN() + 1;
                    book.setN(a);
                    //return;
                }
            }
        }else{
            System.out.println("В библиотеке слишком много книг");
        }
    }

    public void showLib(){
        System.out.println(Arrays.toString(books));
    }
}
