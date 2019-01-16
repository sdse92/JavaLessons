package lesson23.Task1;

import java.util.LinkedHashSet;

public class Bank {

    LinkedHashSet<Accaunt> clients;
    private String name;
    private Accaunt obj1, obj2;

    public Bank(String name) {
        this.name = name;
    }

    public void addClient(Accaunt accaunt){
        clients = new LinkedHashSet<>();
        clients.add(accaunt);
    }

    public boolean contain(Accaunt accaunt){
        return clients.contains(accaunt);
    }

    public synchronized void transferMoney(Accaunt src, Accaunt dst, int amount){
        if (!clients.contains(src)) {
            System.out.println("Аккаунт с которого совершается перевод не существует");
        }else if (!clients.contains(dst)) {
            System.out.println("Аккаунт на который совершается перевод не существует");
        }else if (amount > src.getMoney()) {
            System.out.println("Недостаточно средств на счету");
        }else {
            if (src.getId() < dst.getId()) {
                obj1 = src;
                obj2 = dst;
            } else {
                obj2 = src;
                obj1 = dst;
            }

            synchronized (obj1) {
                synchronized (obj2) {
                    src.setMoney(src.getMoney()-amount);
                    dst.setMoney(dst.getMoney()+amount);
                    Transaction transaction = new Transaction(src, dst, this.name, amount);
                    System.out.println(transaction.toString());
                }
            }

        }
    }
}
