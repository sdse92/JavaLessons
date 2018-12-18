package lesson23;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //java.util.concurrent.Callable - возвращает данные из потока
        //java.util.concurrent.Future
        //get() get(long l, TimeUnit tu) - позволяет получить из потока результат, выкидывает исключение если время вышло
        //cancel() - отменяет текущую задачу
        //isCancelled()
        //is Done() - возвращает true, если задача завершилась

//        FutureTask
        //new FutureTask(Callable<T> c);
        //new FutureTask(Runnable r, T result);

        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "String";
            }
        });

        new Thread(task).start();
        //ждем завершения операции
        String result = task.get();
        System.out.println(result);

        FutureTask<String> task1 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int counter = 0;
                while (!Thread.currentThread().isInterrupted()&& counter < 3){
                    counter++;
                    Thread.sleep(1000);
                }
                return "Finished";
            }
        });
        //запускаем поток с задачей
        new Thread(task1).start();
        Thread.sleep(2000);

        //прерываем выполнение
        task1.cancel(true);

        System.out.println(task1.isCancelled());
        System.out.println(task1.isDone());

        //interfaces Executor - позволяет управлять группой потоков
        //execute(Runnable runnble)

        ExecutorService executorService;// создание объекта

//        executorService.execute(new Thread(task));
//        executorService.submit(new Runnable(){})

        //класс Executors
        //Executors.newFixedThreadPool(int i)
        //Executors.newSingleThreadExecutor()
        //Executors.newCachedThread()
        //Executors.newScheduledThreadPool(int i)

        ExecutorService pool = Executors.newFixedThreadPool(2);
//        for(int i = 0; i < 5; i++){
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("pool: " + Thread.currentThread().getName());
//                }
//            });
//        }
        //метод submit возвращает объект Future, соответвтвенно ему доступны все его методы
        pool.submit(new Thread(task)).get();
        pool.shutdown();

        ExecutorService service = new ThreadPoolExecutor(
                1,//основное количество потоков
                10, //максимальное количество потоков
                2, //как долго избыточные потоки будут простаивать
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>()//очередь для задач
        );
        for (int i = 0; i < 3; i++){
            service.submit(new Runnable() {
                @Override
                public void run() {
                    //код
                }
            });
        }

        //объекты синхронизации
        //CountDownLatch(int num); // указываем количество событий которые должны произойти
        //await(); //блокировка потоков
        //countDown(); //уменьшает счетчик событий

        //Exchanger
        //Exchanger<Message> exchanger
        //messages[4] = exchanger.exchange(messages[4]);
        //exchange(T buffer);
    }
}

//Создать класс "Пользователь". У пользователя поля id и email.
//id уникальный, увеличивать на 1
//класс Аккаунт. Поля id, id_пользователя, колличество средств
//класс Банк. Хранит список всех аккаунтов. Метод перевода денег
//класс Транзакции. Поля Accaunt src, Account dst, Bank bank, int amount, Date date

//User
//Account
//Bank{
//transferMoney(Accaunt src, Accaunt dst, int amount)}
//  src и dst не могут быть одним аккаунтом
//  если средств не достаточно, перевод выполнен быть не может
//  потокобезопасная проверка счета