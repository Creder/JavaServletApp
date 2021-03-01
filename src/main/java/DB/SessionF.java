package DB;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionF {
    private static SessionFactory sessionF;

    private SessionF(){};

    public synchronized static SessionFactory getSessionFactory() {
        if(sessionF == null){
            sessionF = new Configuration().configure().buildSessionFactory();
        }
        return sessionF;
    }
}
