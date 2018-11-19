package lesson13.Chat;

import java.sql.*;
import java.util.Scanner;

public class MySQL {
    private String login;
    private String pass;
    private String email;
    private String message;
    private String roomName;
    Scanner s = new Scanner(System.in);
    User User = new User();

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

    //запрос логина
    public static void getLogin() throws SQLException, ClassNotFoundException {
        String str;
        String sql = "SELECT login FROM user WHERE login = login;";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectUrl,user, password)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                str = resultSet.getString("login");
                System.out.println(str);
            }
        }
    }
}
