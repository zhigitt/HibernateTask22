package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {
//        Session session = Util.getSession().openSession();
//        session.beginTransaction();
//
//        String query = ("drop table users");
//        session.createNamedQuery(query).executeUpdate();
//
//        session.createQuery("drop table users", User.class).executeUpdate();
//
//        session.getTransaction().commit();
//        session.close();
//
//        System.out.println("table deleted");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);

        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();

        System.out.println("User saved!");
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        User user = session.find(User.class, id);
        session.remove(user);
        session.getTransaction().commit();
        session.close();

        System.out.println("User deleted!");
    }

    @Override
    public List<User> getAllUsers() {

        Session session = Util.getSession().openSession();
        session.beginTransaction();
        Query<User> query = session.createQuery("from User ", User.class);
        List<User> users = query.getResultList();
        session.getTransaction().commit();
        session.close();

        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();

        String query = "delete from User";
        session.createQuery(query).executeUpdate();
        session.getTransaction().commit();
        session.close();

        System.out.println("table cleaned!");
    }
}
