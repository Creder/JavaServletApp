package DAO;

import business.Fanfic;
import business.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FanficDAO extends AbstractDAO<Fanfic, User> {

    private Object o;

    @Override
    public List<Fanfic> readEntityList(){
        final Session session = super.getFactory().openSession();
        List<Fanfic> fanfics = new ArrayList<Fanfic>();
        List<Object[]> responseList = null;
        try(session) {
            responseList = session.createQuery("select f.id, f.title, f.author.userId, f.author.username from Fanfic f").getResultList();

        }
        catch (Exception throwables) {
            throwables.printStackTrace();
        }
        finally {
            session.close();
        }
        if(responseList !=null){
            for(Object[] o : responseList){
                Fanfic fanfic = new Fanfic();
                fanfic.setFanficId((Long) o[0]);
                fanfic.setTitle((String) o[1]);
                fanfic.setAuthor(new User((Long) o[2], (String) o[3]));
                fanfics.add(fanfic);
            }
        }

        return fanfics;
    }

    public List<Fanfic> findByUser(String username){
        final Session session = super.getFactory().openSession();

        List<Fanfic> fanfics = new ArrayList<Fanfic>();
        List<Object[]> responseList = null;
        try(session) {
            Query<Object[]> query = session.createQuery("select f.id, f.title, f.content, f.author.userId, f.author.username from Fanfic f where f.author.username = :username");
            query.setParameter("username", username);
            responseList = query.getResultList();
        }
        catch (Exception throwables) {
            throwables.printStackTrace();
        }
        finally {
            session.close();
        }
        if(responseList !=null){
            for(Object[] o : responseList){
                Fanfic fanfic = new Fanfic();
                fanfic.setFanficId((Long) o[0]);
                fanfic.setTitle((String) o[1]);
                fanfic.setContent((String) o[2]);
                fanfic.setAuthor(new User((Long) o[3], (String) o[4]));
                fanfics.add(fanfic);
            }
        }

        return fanfics;
    }

    @Override
    public Fanfic findById(Long fanficId) {
        Fanfic fanfic = new Fanfic();
        Object[] response = null;
        final Session session = super.getFactory().openSession();
        if(fanficId != null){
                try (session){
                    Query<Object[]> query = session.createQuery("select f.id, f.title, f.content, f.author.userId, f.author.username from Fanfic f where f.fanficId=:fanficId");
                    query.setParameter("fanficId", fanficId);
                    response = query.uniqueResult();

                }
                catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            finally {
                    session.close();
                }
                if(response != null){
                    fanfic.setFanficId((Long) response[0]);
                    fanfic.setTitle((String) response[1]);
                    fanfic.setContent((String) response[2]);
                    fanfic.setAuthor((new User((Long) response[3], (String) response[4])));
                }
        }
        return fanfic;
    }
}
