package lesson23.Task1;

import java.util.Date;

public class Transaction {

    private Accaunt src;
    private Accaunt dst;
    private String bankname;
    private int amount;
    private Date date;

    public Transaction(Accaunt src, Accaunt dst, String bankname, int amount) {
        this.src = src;
        this.dst = dst;
        this.bankname = bankname;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction{" + src +
                "} перевел {" + dst + "} " +
                amount + " денег " +
                "через банк " + bankname +
                ", " + date +
                '}';
    }
}
