package dao;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao implements Dao{

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable()  {
        String sql = "CREATE TABLE IF NOT EXISTS Article (" +
                "id INTEGER PRIMARY KEY NOT NULL, " +
                "title TEXT NOT NULL, idUser INTEGER NOT NULL);";
        //
        try {
            DriverManager.registerDriver (new JDBC());
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Object o) {
        String sql = "INSERT INTO Article (id, title, idUser) VALUES (?, ?, ?);";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ((Article) o).getId());
            statement.setString(2, ((Article) o).getTitle());
            statement.setInt(3, ((Article) o).getIdUser());
            int row = statement.executeUpdate();
            System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Article WHERE id=?;";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int row = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Object o) {
        String sql = "UPDATE Article SET id=?, title=? , idUser=? WHERE id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ((Article) o).getId());
            statement.setString(2, ((Article) o).getTitle());
            statement.setInt(3, ((Article) o).getIdUser());
            statement.setInt(4, id);
            int row = statement.executeUpdate();
            System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object> getAll() {
        String sql = "SELECT * FROM Article;";
        List<Object> articles = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            for(int i = 0; resultSet.next(); i++){
                articles.add(i, new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getInt("idUser")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public Object getById(int id) {
        String sql = "SELECT * FROM Article WHERE id=?;";
        Object o = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            o = new Article(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getInt("idUser"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
}
