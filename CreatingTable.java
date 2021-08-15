import java.sql.Connection;
import java.sql.*;

public class CreatingTable {
    //поля для подключения к mysql серверу
    private static final String userName = "root";
    private static final String password = "Frfltvbr";
    private static final String connectionURL = "jdbc:mysql://localhost:3306/mysql";

    // конструктор для создания таблицы при status=0  и подсоединению к базе данных
    public CreatingTable(int status) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             Statement statement = connection.createStatement()) {
            System.out.println("Соединение успешно");
            if (status==0){
                System.out.println("Создание новой таблицы phone");
                statement.execute("DROP TABLE phone");
                statement.executeUpdate("CREATE TABLE phone (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        "username VARCHAR(50),phones VARCHAR(11))");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}




