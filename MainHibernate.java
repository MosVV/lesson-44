import dao.Phone;
import hibernate.PhoneDAOHibernate;
import hibernate.PhoneService;

import java.sql.SQLException;

public class MainHibernate {
    public static void main(String[] args)throws SQLException {
        PhoneService phoneService=new PhoneService();
        Phone phone=new Phone("Ivan","143253246");
        phoneService.savePhone(phone);
    }
}
