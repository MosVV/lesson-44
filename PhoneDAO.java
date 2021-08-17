package dao;

import dao.AbstractDAO;

import java.sql.*;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;


public class PhoneDAO extends AbstractDAO<Phone, Long> {


    //поля для подключения к mysql серверу
    private Connection connection;
    private DatabaseMetaData ConnectorDB;
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM phone";
    public static final String SQL_SELECT_USER_ID = "SELECT * FROM phone WHERE id=?";
    public static final String INSERT_QUERY = "INSERT INTO phone (username, phones) VALUES (?,?)";


    @Override
    public List<Phone> getAll() {

        return null;
    }

    @Override
    public Phone findEntityById(Long id) {
        String connectionURL = "jdbc:mysql://localhost:3306/mysql";
        String userName = "root";
        String password = "Frfltvbr";
        Connection connectionDB = null;
        Phone phone = new Phone();
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USER_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                phone.setName(resultSet.getString("name"));
                phone.setPhone(resultSet.getString("phones"));
                phone.setId(resultSet.getInt("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return phone;
    }

    @Override
    public Phone update(Phone entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        String connectionURL = "jdbc:mysql://localhost:3306/mysql";
        String userName = "root";
        String password = "Frfltvbr";
        Connection connectionDB = null;
        String DELETE="DELETE FROM ADS WHERE Id="+id;
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return false;
    }


    @Override
    public boolean create(Phone phone) {
        String connectionURL = "jdbc:mysql://localhost:3306/mysql";
        String userName = "root";
        String password = "Frfltvbr";

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
