package dao;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao{

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS User (" +
                "id INTEGER PRIMARY KEY NOT NULL, " +
                "login TEXT NOT NULL);";
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
        String sql = "INSERT INTO User (id, login) VALUES (?, ?);";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ((User) o).getId());
            statement.setString(2, ((User) o).getLogin());
            int row = statement.executeUpdate();
            System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM User WHERE id=?;";
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
        String sql = "UPDATE User SET id=?, login=? WHERE id=?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ((User) o).getId());
            statement.setString(2, ((User) o).getLogin());
            statement.setInt(3, id);
            int row = statement.executeUpdate();
            System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object> getAll() {
        String sql = "SELECT * FROM User;";
        List<Object> users = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            for(int i = 0; resultSet.next(); i++){
                users.add(i, new User(resultSet.getInt("id"), resultSet.getString("login")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Object getById(int id) {
        String sql = "SELECT * FROM User WHERE id=?;";
        Object o = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            o = new User(resultSet.getInt("id"), resultSet.getString("login"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
}
