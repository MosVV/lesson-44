package hibernate;


import dao.Phone;
import hibernate.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


//import javax.transaction.Transaction;

public class PhoneDAOHibernate {

    public Phone findByID(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Phone.class, id);
    }

    public void save(Phone phone) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(phone);
        tx1.commit();
        session.close();
    }

    public void update(Phone phone) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(phone);
        tx1.commit();
        session.close();
    }

    public void delete(Phone phone) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(phone);
        tx1.commit();
        session.close();
    }



    public List<Phone> findAll() {
        List<Phone> users = (List<Phone>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Phone").list();
        return users;
    }
}
