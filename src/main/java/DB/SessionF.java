package DB;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionF {
    public static SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
