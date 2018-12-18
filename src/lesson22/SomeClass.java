package lesson22;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

public class SomeClass {
    //чтение и запись всегда будут атомарными
    //чтение всегда вернет актуальное значение из памяти
    private static volatile boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++){
            new SomeThread().start();
        }

        Thread.sleep(3000);
        run = false;
    }

    private static class SomeThread extends Thread{
        @Override
        public void run(){
            while (run){
                try {
                    sleep(1);
                }catch (InterruptedException e){
                    run = false;
                    e.printStackTrace();
                }
            }
        }
    }

//  коллекции с синхронизированным доступом
    //Vector
    //Hashtable
    //Stack
    //StringBuffer

//    однопоточные коллекции плюс декораторы
    //List<String> list = Collections.synchronizedList(new ArrayList<>());
    //Set<String> set = Collections.synchronizedSet(new HashSet<>());
    //Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

//    java.util.concurrent. - java 1.5
    //многопоточные коллекции
    //интерфейс ConcurrentMap
    //чтение и запись всегда будут атомарными
    //операции чтения не требуют блокировок
    //операции записи могут происходить без блокировок

    //putIfAbsent(key, val)
    //remove(key,val)
    //replace(key, oldValue, newValue)

    //реализации
    //ConcurrentHashMap - блокировка на уровне сегментов
    //ConcurrentSkipList (Skip List алгоритм)

    //ConcurrentHashMap - блокировка на уровне сегментов
    //CopyOnWriteArrayList (много читателей и мало писателей)
    //CopyOnWriteArraySet

    //BlockingQueue - блокирующие очереди
    //BlockingDeque - блокирующие очереди
    //вставка
    //add(o) - Exception
    //offer(o) - чтение (вернет объект)
    //put(o) - положит в очередь когда освободится место

    //удаление
    //remove() - Excrption выкинет исключение если нечего удалять из очереди
    //poll()
    //take() - блокировка потока

//    ArrayBlockingQueue (размер фиксированый)
//
//        new ArrayBlockingQueue(int capacity)
//        new ArrayBlockingQueue(int capacity, boolean fair)
//        new ArrayBlockingQueue(int capacity, boolean fair, Collection collection)
//
//        LinkedBlockingQueue() (размер фиксирован Integer.MAX_VALUE)
//        LinkedBlockingQueue(int capacity)
//        LinkedBlockingQueue(Collection collection)

//    SynchronousQueue

    //используя блокирующие очереди сосчитать топ 100 слов

}
