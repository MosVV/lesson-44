import java.sql.*;
import java.util.Scanner;

public class InsertDataPreparedStatement {

        //поля для подключения к mysql серверу
        String userName = "root";
        String password = "Frfltvbr";
        String connectionURL = "jdbc:mysql://localhost:3306/mysql";
        private Connection connection;
        String INSERT_QUERY = "INSERT INTO phone (username, phones) VALUES (?,?)";

        public InsertDataPreparedStatement() {
        }

        public void recordingNewData() throws ClassNotFoundException, SQLException {
            try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Добавление данных в таблицу, 0 выход");
                while (true) {
                    System.out.println("Ведите ФИО");
                    String name = scanner.nextLine();
                    System.out.println("Ведите телеон");
                    String phone = scanner.nextLine();
                    if (Integer.parseInt(name) == 0 || Integer.parseInt(phone) == 0) {
                        break;
                    }
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, phone);
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
