package lesson8;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.Arrays;

public class BookHandler {

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Book (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "title TEXT NOT NULL, pages INTEGER NOT NULL);";
        //
        DriverManager.registerDriver (new JDBC());
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }


    }

    public static void insertIntoTable(Book book) throws SQLException {
        String sql = "INSERT INTO Book (title, pages)" +
                "VALUES (?, ?);";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getPages());

            int row = statement.executeUpdate();

            System.out.println(row);
        }
    }

    public static Book[] selectData() throws SQLException {
        //String sql = "SELECT * FROM Book WHERE id = ?;";
        String sql = "SELECT * FROM Book;";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            Book[] books = new Book[4];
            for(int i = 0; resultSet.next(); i++){
                books[i] = new Book(resultSet.getString("title"), resultSet.getInt("pages"));

            }return books;

//            Book book = new Book();
//            while (resultSet.next()){
//                book.setTitle(resultSet.getString("title"));
//                book.setPages(resultSet.getInt("pages"));
//                String title = resultSet.getString("title");
//                int pages = resultSet.getInt("pages");
//                System.out.println("title = " + title);
//                System.out.println("pages = " + pages);
//            }
//            return book;

        }
    }

    public static void main(String[] args) {

        Book book1 = new Book("Псина", 13);
        Book book2 = new Book("Гусь", 666);
        Book book3 = new Book("Дикобраз", 69);

        try{
            //BookHandler.createTable();
            //BookHandler.selectData(3);
//
            System.out.println(Arrays.toString(BookHandler.selectData()));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
