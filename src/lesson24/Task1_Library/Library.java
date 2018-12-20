package lesson24.Task1_Library;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Library {
    ConcurrentHashMap<String, Book> lib = new ConcurrentHashMap<>();
    ArrayList<Book> list;

    public void put(Book book){
        lib.putIfAbsent(book.getName(), book);
//        list = lib.replaceAll(book.getName(), book);
    }

    public synchronized Book take(String name){
        Book b = lib.get(name);
        lib.remove(name);
        return b;
    }

    public void back(Book book){
        lib.put(book.getName(), book);
    }

    public void show(){
        System.out.println(lib.toString());
    }
}
