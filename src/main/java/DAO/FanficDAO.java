package DAO;

import business.Fanfic;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FanficDAO extends AbstractDAO<Fanfic> {

    @Override
    public List<Fanfic> readAllList(){
        List<Fanfic> fanfics;
        try(final Session session = super.getFactory().openSession()) {
            fanfics = session.createQuery("select u from Fanfic u", Fanfic.class).getResultList();
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
                    Query<Fanfic> query = session.createQuery("from Fanfic u where u.title=:fanficname", Fanfic.class);
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
