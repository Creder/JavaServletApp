package DAO;

import DB.SessionF;
import business.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao implements GenericDao<User> {
    private final SessionFactory factory;

    public UserDao(){
        this.factory = SessionF.getSessionFactory();
    };

    @Override
    public void create(User user) {
            try (final Session session = factory.openSession()){
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            }
            catch (Exception throwables) {
                throwables.printStackTrace();
            }

    }
    @Override
    public List<User> readAllList(){
        List<User> users;
        try(final Session session = factory.openSession()) {
            users = session.createQuery("select u from User u", User.class).getResultList();
        }
        return users;
    }

    @Override
    public User read(User user) {
        User result = null;
        if(user != null){
            String username = user.getUsername();
            if(username != null || !username.equals(""))
                try (final Session session = factory.openSession()){
                    Query<User> query = session.createQuery("from User u where u.username=:username", User.class);
                    query.setParameter("username", username);
                    result = query.uniqueResult();
                }
                catch (Exception throwables) {
                    throwables.printStackTrace();
                }
        }
        return result;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
