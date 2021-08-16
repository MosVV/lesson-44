package dao;

import dao.AbstractDAO;

import java.sql.*;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;


public class PhoneDAO extends AbstractDAO {

    private int id;
    private String name;
    private String phone;

    //поля для подключения к mysql серверу


    private Connection connection;
    private DatabaseMetaData ConnectorDB;
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";
    public static final String SQL_SELECT_USER_ID = "SELECT * FROM users WHERE id=?";


    @Override
    public List getAll() {

        return null;
    }

    @Override
    public Object findEntityById(Object id) {
        return null;
    }

    /*@Override
    public String findEntityById(Integer id) {
        connectionDB.getConnection();
        String name = "";
        String phone = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                name = rs.getString(2);
                phone=rs.getString(3);

                // user = new User(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ФИО: " + name +" телефон: "+ phone;
    }*/

    @Override
    public Object update(Object entity) {
        return null;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public boolean create(Phone phone) {
        String connectionURL = "jdbc:mysql://localhost:3306/mysql";
        String userName = "root";
        String password = "Frfltvbr";
        String INSERT_QUERY = "INSERT INTO phone (username, phones) VALUES (?,?)";
        Connection connectionDB = null;
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {

            preparedStatement.setString(2, phone.getName());
            preparedStatement.setString(3, phone.getPhone());
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return false;
    }


}
