package DAO;

import business.Fanfic;
import business.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO extends AbstractDAO<User, Fanfic> {

    @Override
    public List<User> readEntityList(){
        List<User> users;
        try(final Session session = super.getFactory().openSession()) {
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
                try (final Session session = super.getFactory().openSession()){
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
