package DAO;

import business.Fanfic;
import business.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO extends AbstractDAO<User, Fanfic> {

    @Override
    public List<User> readEntityList(){
        List<User> users = null;
        final Session session = super.getFactory().openSession();
        try(session) {
            users = session.createQuery("select u from User u", User.class).getResultList();
            session.close();
        }
        catch (Exception throwables) {
            throwables.printStackTrace();
        }
        finally {
            session.close();
        }
        return users;
    }

    @Override
    public User findById(Long userId) {
        User result = null;
        final Session session = super.getFactory().openSession();
        if(userId != null){
                try (session){
                    Query<User> query = session.createQuery("from User u where u.userId=:userId", User.class);
                    query.setParameter("userId", userId);
                    result = query.uniqueResult();
                }
                catch (Exception throwables) {
                    throwables.printStackTrace();
                }
                finally {
                    session.close();
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

    public User findByUsername(User user) {
        User result = null;
        final Session session = super.getFactory().openSession();
        if(user != null){
            String username = user.getUsername();
            try (session){
                Query<User> query = session.createQuery("from User u where u.username=:username", User.class);
                query.setParameter("username", username);
                result = query.uniqueResult();
            }
            catch (Exception throwables) {
                throwables.printStackTrace();
            }
            finally {
                session.close();
            }
        }
        return result;
    }
}
