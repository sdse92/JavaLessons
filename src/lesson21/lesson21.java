package lesson21;

import java.util.ArrayList;
import java.util.List;

public class lesson21 {
    public static void main(String[] args) throws InterruptedException {
        Sync sync = new Sync();
        List<Sync.Adder> adderList = new ArrayList<>();
        //создаем потоки
        for (int i = 0; i < 100; i++){
            adderList.add(sync.new Adder());
        }
        //запускаем потоки
        for (Sync.Adder adder: adderList){
            adder.start();
        }
        //ждем завершения
        for (Sync.Adder adder: adderList){
            adder.join();
        }
        //вывод результата
        System.out.println("Result: " + sync.counter);
    }
}
// общий участок памяти который будем изменять из разных потоков
class Sync{
   int counter;

   private synchronized void increment(){
       //при synchronized на методе происходит синхронизация на текущем объекте (this)
       counter++;
   }

   public class Adder extends Thread{
       @Override
       public void run(){
           for (int i = 0; i < 100_000; i++){
//               counter++;

//               // все что внутри блока одновременно может выполнять только один поток
//               synchronized (Sync.this){ //- объект, на котором происходит синхронизация
//                   counter++;
//               }

               increment();
           }
       }
   }
}

class Storage {
    int booksCount = 0;

    public synchronized void getBook() throws InterruptedException {
        System.out.println("getBook started");
        while (booksCount < 1){
            wait();
        }
        booksCount--;
        System.out.println("Одну книгу забрали из библиотеки");
        System.out.println("В библиотеке осталось " + booksCount + " книг");
        notify(); //notifyAll();
        System.out.println("getBook stopped");
    }

    public synchronized void putBook() throws InterruptedException {
        System.out.println("putBook started");
        while (booksCount >= 5){
            wait();
        }
        booksCount++;
        System.out.println("Книга добавлена");
        System.out.println("Книг в библиотеке " + booksCount);
        notify();
        System.out.println("putBook stopped");
    }
}

class Put implements Runnable{

    Storage storage;
    public Put(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++){
            try {
                storage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Get implements Runnable{

    Storage storage;
    public Get(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++){
            try {
                storage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Library{
    public static void main(String[] args) {
//        Storage storage = new Storage();
//        Put put = new Put(storage);
//        Get get = new Get(storage);
//        new Thread(put).start();
//        new Thread(get).start();


        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                synchronized (obj1){
                    //обработка данных
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thred 1 locked obj1");
                    synchronized (obj2){
                        System.out.println("Thred 1 locked both obj");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                synchronized (obj2){
                    System.out.println("Thred 2 locked obj2");
                    synchronized (obj1){
                        System.out.println("Thred 2 locked both obj");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}