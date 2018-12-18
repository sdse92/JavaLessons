package lesson20;

public class Lesson20 {
    public static void main(String[] args) throws InterruptedException {
        // методы класса Thread:
        // currentThread() - получить текущий поток
        // setName(String) - задать имя потока
        // getName() - получить имя потока
        // isAlive() - возвращает true, если поток еще исполняется
        // jоin() - ожидает завершения потока исполнения,
        // вызывающий поток ожидает, когда указанный поток присоединится к нему
        // getState() - возвращает текущее состояние потока
        // sleep(1000) - приостанавливает поток на указанное количество миллисекунд

        // setDaemon(true) - поток завершится, когда завершится основной поток
        // isInterrupted() - прерван ли поток
        // interrupt() - устанавливает флаг Interrupted в true
        System.out.println(Thread.currentThread().getName());

        // Создаём поток
        Thread thread = new Thread();
//        // запускаем
        thread.start();
        // сразу завершается и не делает ничего полезного

        Thread thread1 = new  MyThread();
        thread1.start();

        Thread thread2 = new Thread(new OtherThread());
        thread2.start();

        // создаем потоки, пока позволяют ресурсы
        for (int i = 0; i < 10; i++) {
            Thread thread3 = new Thread(new OtherThread());
            thread3.setName("T-" + i);
            thread3.start();
        }

        // Инициализируем анонимным классом
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Проверяем работает ли текущий поток
                System.out.println("Running: " + Thread.currentThread().isAlive());
                System.out.println("Running: " + Thread.currentThread().getState());
            }
        });

        // Проверяем работает ли наш поток до старта
        System.out.println("Before start: " + thread4.isAlive());
        System.out.println("Before start: " + thread4.getState());
        thread4.start();
        // Ожидаем пока поток завершится
        thread4.join();
        // Снова проверяем
        System.out.println("After join: " + thread4.isAlive());
        System.out.println("After join: " + thread4.getState());

        //    Java программа работает до тех пор, пока есть незавершенные потоки
        //    Например, эта не остановится никогда.
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread5.start();

//        Но это касается основных потоков, а помеченные как
//        daemon, будут остановлены сразу после остановки последнего основного потока.

        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("thread6");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread6.setDaemon(true); // Использовать daemon потоки не рекомендуется,
//        // кроме того случая, когда вы уверены в том, что делаете
        thread6.start();

        // завершение потоков
//        Поток останавливатся в следующих случаях:
//        1. Поток выполнил все инструкции и выходит из метода run().
//        2. Было выброшено необрабатываемое исключение в методе run().
//        3. Остановилась JVM.
//        4. Это был daemon поток и последний основной поток завершил свою работу.

        // механизм прерываний - interruption:
//        у каждого потока есть флаг, который можно проверить методом isInterrupted(),
//        и метод interrupt(), который выставляет его в true, или выбрасывает InterruptedException

        Thread thread7 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Проверяем флаг: не было ли выполение потока прервано,
                // если да, то выходим
                while (!Thread.currentThread().isInterrupted()){
                    try {
                        System.out.println("thread7");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // Если выбрасывается исключение InterruptedException, то флаг не переводится в true. Для этого
                        // вручную вызывается метод interrupt() у текущего потока
                        Thread.currentThread().interrupt();
                        System.out.println("InterruptedException");
                    }
                }
            }
        });

        thread7.start();
        // Прерываем выполнение потока
        thread7.interrupt();

    }
}

/*
Для того, чтобы поток исполнял нужные нам инструкции,
нужно унаследоваться от java.lang.Thread
и переопределить метод run()
*/

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread " + Thread.currentThread().getName());
    }
}

/*
Для того, чтобы поток исполнял нужные нам инструкции,
нужно реализовать интерфейс java.lang.Runnable
и передать объект в конструктор класса java.lang.Thread
Интерфейс обычно выбирается чаще
*/
class OtherThread implements Runnable {

    @Override
    public void
    run() {
        System.out.println("OtherThread " + Thread.currentThread().getName());
    }
}
