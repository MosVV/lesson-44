import java.sql.*;
import java.util.Scanner;

public class RetrieveData {
    //поля для подключения к mysql серверу
    private String userName = "root";
    private String password = "Frfltvbr";
   private String connectionURL = "jdbc:mysql://localhost:3306/mysql";
    private Connection connection;
    String SELECT_QUERY = "SELECT * FROM phone ";

    public RetrieveData() {
    }
    public void getData()throws SQLException {
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "P%");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("id"+"\t"+"ФИО"+"                    телефон");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id")+"\t"+ resultSet.getString("username")+"\t"+
                        resultSet.getString("phones"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}