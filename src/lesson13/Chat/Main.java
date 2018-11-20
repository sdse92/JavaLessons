package lesson13.Chat;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        User user = new User();
        MySQL sql = new MySQL();
        Scanner sc = new Scanner(System.in);
        while (true){
            if (sql.getUsers() != null){
                if (user.isStatus() == false){
                    System.out.println("Войдите в учетную запись");
                    System.out.println("Введите логин");
                    String s = sc.nextLine();
                    if (s.equals("exit")) { break;}
                    if (s.equals("create new user")){ user.add(); }
                    user.login(s);
                }
            }else{ user.add();}
            if (user.isStatus() == true){
                System.out.print(user.getLogin() + ": ");
                String s = sc.nextLine();
                if (s.equals("exit")) { break;}
                if (s.equals("create new user")){ user.add(); }
                if (s.equals("logout")){ user.logout(); }
            }
        }
    }
}
