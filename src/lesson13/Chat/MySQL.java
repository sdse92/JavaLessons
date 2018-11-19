package lesson13.Chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySQL {
    private String login;
    private String pass;
    private String email;
    private String message;
    private String roomName;
    Scanner s = new Scanner(System.in);

    static String connectUrl = "jdbc:mysql://localhost:3306/chat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //адрес где установлен сервер
    static String user = "user1"; //логин
    static String password = "detra1"; //пароль

    public void setLogin(String login) { this.login = login; }

    public void setPass(String pass) { this.pass = pass; }

    public void setEmail(String email) { this.email = email; }

    //добавить пользователя
    public void insertIntoTable() throws SQLException {
        String sql = "INSERT INTO user (login, password, email)" +
                "VALUES ('" + login + "','" + pass + "','" + email + "');";

        try (Connection connection = DriverManager.getConnection(connectUrl,user, password)){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }
}
