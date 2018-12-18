package lesson23.Task1;

public class Main {
    public static void main(String[] args) {
        User first = new User("re@g.com");
        User second = new User("re1@g.com");
        Accaunt firstFirst = new Accaunt(first, 3000);
//        System.out.println(firstFirst.toString());
        Accaunt firstSecond = new Accaunt(first, 6000);
        Accaunt secondFirst = new Accaunt(second, 4000);
        System.out.println(secondFirst.toString());
        Bank bank1 = new Bank("Fortress");
        bank1.addClient(firstFirst);
//        System.out.println(bank1.contain(firstFirst));
        bank1.addClient(secondFirst);
//        System.out.println(bank1.contain(secondFirst));
        bank1.addClient(firstSecond);
//        System.out.println(bank1.contain(firstSecond));
        bank1.transferMoney(firstFirst, secondFirst, 1000);
        System.out.println(secondFirst.toString());
    }
}
