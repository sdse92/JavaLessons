package lesson23.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Accaunt {
    private static AtomicInteger next_id = new AtomicInteger();
    private final int id;
    private int user_id;
    private int money;

    public Accaunt(User user, int money) {
        this.id = next_id.getAndIncrement();
        this.user_id = user.getId();
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Accaunt " + id +
                ", user " + user_id +
                ", money=" + money;
    }
}
