package DAO;

import DB.SessionF;
import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;

import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {
    private final SessionFactory factory;

    public AbstractDAO(){
        this.factory = SessionF.getSessionFactory();
    }

    @Override
    public void create(T entity) throws PSQLException {
        Transaction tr = null;
        Session session = factory.openSession();
        try {
            if(entity !=null){
                tr = session.beginTransaction();
                session.save(entity);
                tr.commit();
            }
        }catch (PersistenceException e){
            if(tr!=null) tr.rollback();
            Throwable t = e.getCause().getCause();
            if(t instanceof PSQLException){
                throw (PSQLException)t;
            }

        }finally {
            session.close();
        }

    }

    @Override
    public List<T> readAllList() {
        return null;
    }

    @Override
    public T read(T entity) {
        return null;
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }

    public SessionFactory getFactory(){ return factory;}
}
