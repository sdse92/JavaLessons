package lesson24.Task1_Library;

import java.util.HashMap;
import java.util.Map;

public class Visiter {
    Map<String, Book> onRead= new HashMap<String, Book>();
    Library library = new Library();

    public void getBook(String name){
        onRead.put(name, library.take(name));
    }

    public void putBack(String name){
        Book b = onRead.get(name);
        onRead.remove(name);
        library.put(b);
    }

    public void show(){
        System.out.println(onRead.toString());
    }
}
