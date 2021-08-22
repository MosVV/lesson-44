import dao.Phone;
import dao.PhoneDAO;

public class Main {
    public static void main(String[] args) {
        PhoneDAO phoneDAO= new PhoneDAO();
        Phone phone=new Phone("Иванов","123507035670");
        phoneDAO.create(phone);
    }
}
