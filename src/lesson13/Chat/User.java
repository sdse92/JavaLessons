package lesson13.Chat;

import java.sql.SQLException;
import java.util.Scanner;

public class User {
    private String login;
    private String email;
    private String password;
    private boolean status = false;
    Scanner s = new Scanner(System.in);


    public void add() throws SQLException {
        MySQL sql = new MySQL();
        System.out.println("Введите логин: ");
        sql.setLogin(s.nextLine());
        System.out.println("Введите пароль: ");
        sql.setPass(s.nextLine());
        System.out.println("Введите email: ");
        sql.setEmail(s.nextLine());
        sql.insertIntoTable();
        System.out.println("Пользователь создан");
    }

    public String getLogin() {
        return login;
    }

    public void login(String login){
        MySQL sql = new MySQL();
        sql.setLogin(login);

    }

    public boolean isStatus() { return status; }
}
