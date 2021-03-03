package DAO;

import business.Fanfic;
import business.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FanficDAO extends AbstractDAO<Fanfic, User> {

    @Override
    public List<Fanfic> readEntityList(){
        List<Fanfic> fanfics;
        try(final Session session = super.getFactory().openSession()) {
            fanfics = session.createQuery("select f from Fanfic f", Fanfic.class).getResultList();
        }
        return fanfics;
    }

    @Override
    public List<Fanfic> readEntityList(User user){
        List<Fanfic> fanfics;
        try(final Session session = super.getFactory().openSession()) {
            Query<Fanfic> query = session.createQuery("select f from Fanfic f join User u on u.userId =f.author.userId where f.author.userId =:user_id", Fanfic.class);
            query.setParameter("user_id", user.getUserId());
            fanfics = query.getResultList();
        }
        return fanfics;
    }

    @Override
    public Fanfic read(Fanfic fanfic) {
        Fanfic result = null;
        if(fanfic != null){
            String fanficname = fanfic.getTitle();
            if(fanficname != null || !fanficname.equals(""))
                try (final Session session = super.getFactory().openSession()){
                    Query<Fanfic> query = session.createQuery("from Fanfic f where f.title=:fanficname", Fanfic.class);
                    query.setParameter("fanficname", fanficname);
                    result = query.uniqueResult();
                }
                catch (Exception throwables) {
                    throwables.printStackTrace();
                }
        }
        return result;
    }
}
