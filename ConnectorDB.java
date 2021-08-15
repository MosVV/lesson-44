import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Frfltvbr";

    public Connection getConnection() {
    Connection connection=null;
        try {
            Class.forName(DB_DRIVER);
            connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("Подключено к базе данных");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Нет подключения к базе данных");
        }
        return connection;
    }



}