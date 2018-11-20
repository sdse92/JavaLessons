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

    public void login(String userlogin) throws SQLException, ClassNotFoundException {
        MySQL sql = new MySQL();
        sql.setLogin(userlogin);
        String getLogin = sql.getLogin();
        if (getLogin.equals(userlogin)) {
            System.out.println("Введите пароль");
            String pass = s.nextLine();
            sql.setPass(pass);
            String getPass = sql.getPass();
            if (getPass.equals(pass)){
                status = true;
                login = getLogin;
            }else{
                System.out.println("Вы ввели не верный пароль");
            }
        }else System.out.println("Пользователя с таким логином не существует");
        return;
    }

    public void logout(){
        status = false;
    }

    public boolean isStatus() { return status; }
}
