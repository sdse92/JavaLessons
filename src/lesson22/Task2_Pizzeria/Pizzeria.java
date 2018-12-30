package lesson22.Task2_Pizzeria;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Pizzeria {
    private BlockingQueue<String> orderQueue = new LinkedBlockingQueue<String>();
    private BlockingQueue<String> kitchenQueue = new LinkedBlockingQueue<String>();
    private BlockingQueue<String> readyQueue = new LinkedBlockingQueue<String>();

    public Pizzeria(){
        for (int i = 1; i <= 6; i++) {
            new Thread(new Client()).start();
        }
        new Thread(new Waiter()).start();
        new Thread(new Cook()).start();
    }


    class Client implements Runnable{

        @Override
        public void run() {
            try {
                orderQueue.put("order" + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + " make order");
                while (readyQueue.take().endsWith("ready")){
                    System.out.println(Thread.currentThread().getName() + " take order");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Waiter implements Runnable{

        @Override
        public void run() {
            String order;
            try {
                if (kitchenQueue.isEmpty()){
                    Thread.sleep(1000);
                }
                while (!kitchenQueue.isEmpty()){
                    order = orderQueue.take();
                    System.out.println("Waiter take " + order);
                    kitchenQueue.put(order);
                    System.out.println("Waiter handed over " + order);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Cook implements Runnable{

        @Override
        public void run() {
            String takeOrder;
            try {
                if (kitchenQueue.isEmpty()){
                    Thread.sleep(1000);
                }
                while (kitchenQueue.size() > 0 || !orderQueue.isEmpty()){
                    takeOrder = kitchenQueue.take();
                    System.out.println("Cook started cooking " + takeOrder);
                    readyQueue.put(takeOrder + " ready");
                    System.out.println("Cook finished " + takeOrder);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


