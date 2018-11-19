package lesson13.Chat;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        User user = new User();
        Scanner s = new Scanner(System.in);
        while (true){

            if (s.nextLine().equals("exit")) { break; }
            if (s.nextLine().equals("create new user")){ user.add(); }
        }
    }
}
