package lesson13.Chat;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        while (true){
            String s = sc.nextLine();
            if (s.equals("exit")) { break; }
            if (s.equals("create new user")){ user.add(); }
            System.out.println(user.isStatus());
            if (user.isStatus() == false){
                System.out.println("Войдите в учетную запись");
                user.login(s);
            }
        }
    }
}
