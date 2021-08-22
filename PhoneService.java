package hibernate;

import dao.Phone;

import java.util.List;

public class PhoneService {
    private PhoneDAOHibernate phoneDAOHibernate = new PhoneDAOHibernate();

    public PhoneService() {
    }

    public Phone findUser(int id) {
        return phoneDAOHibernate.findByID(id);
    }

    public void savePhone(Phone phone) {
        phoneDAOHibernate.save(phone);
    }

    public void deleteUser(Phone phone) {
        phoneDAOHibernate.delete(phone);
    }

    public void updateUser(Phone phone) {
        phoneDAOHibernate.update(phone);
    }

    public List<Phone> findAllUsers() {
        return phoneDAOHibernate.findAll();
    }


}
