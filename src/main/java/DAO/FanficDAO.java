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
            responseList = session.createQuery("select f.id, f.title, f.content, f.author.userId, f.author.username from Fanfic f").getResultList();

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
    public List<Fanfic> readEntityList(User user){
        List<Fanfic> fanfics = null;
        final Session session = super.getFactory().openSession();
        try(session) {
            Query<Fanfic> query = session.createQuery("select f.id, f.title, f.content, f.author.userId, f.author.username from Fanfic f join User u on u.userId =f.author.userId where f.author.userId =:user_id");
            query.setParameter("user_id", user.getUserId());
            fanfics = query.getResultList();

        }
        catch (Exception throwables) {
            throwables.printStackTrace();
        }
        finally {
            session.close();
        }
        return fanfics;
    }

    @Override
    public Fanfic read(Fanfic fanfic) {
        Fanfic result = null;
        final Session session = super.getFactory().openSession();
        if(fanfic != null){
            String fanficname = fanfic.getTitle();
            if(fanficname != null || !fanficname.equals(""))
                try (session){
                    Query<Fanfic> query = session.createQuery("from Fanfic f where f.title=:fanficname", Fanfic.class);
                    query.setParameter("fanficname", fanficname);
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
