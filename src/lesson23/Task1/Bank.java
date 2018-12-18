package lesson23.Task1;

import java.util.LinkedHashSet;

public class Bank {

    LinkedHashSet<Accaunt> clients;
    private String name;

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
        if (clients.contains(src) != false) {
            System.out.println("Аккаунт с которого совершается перевод не существует");
        }else if (clients.contains(dst) != false) {
            System.out.println("Аккаунт на который совершается перевод не существует");
        }else if (amount > src.getMoney()) {
            System.out.println("Недостаточно средств на счету");
        }else {
            src.setMoney(src.getMoney() - amount);
            dst.setMoney(dst.getMoney() + amount);
        }
        Transaction transaction = new Transaction(src, dst, this.name, amount);
        System.out.println(transaction.toString());
    }
}
