package lesson13;

import java.sql.*;

public class MysqlConnect {
    static String connectUrl = "jdbc:mysql://localhost:3306/cources"; //адрес где установлен сервер
    static String user = "user1"; //логин
    static String password = "detra1"; //пароль

    //запрос данных
    public static void selectData() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM teacher;";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectUrl,user, password)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String str1 = resultSet.getString("name");
                String str2 = resultSet.getString("surname");
                int a = resultSet.getInt("salary");
                System.out.println("name = " + str1);
                System.out.println("surname = " + str2);
                System.out.println("salary = " + a);
            }

        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            MysqlConnect.selectData();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
//create database dbname;
