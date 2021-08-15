import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class PhoneDAO extends AbstractDAO {
    //поля для подключения к mysql серверу

    private ConnectorDB connectionDB = new ConnectorDB();
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

    @Override
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
    }

    @Override
    public Object update(Object entity) {
        return null;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }
}
