package lesson23.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static AtomicInteger next_id = new AtomicInteger();
    private int id;
    private String email;

    public User(String email) {
        this.id = next_id.getAndIncrement();
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
