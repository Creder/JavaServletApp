package DAO;

import org.hibernate.JDBCException;
import org.postgresql.util.PSQLException;

import java.util.List;

public interface GenericDAO<T> {
    public void create(T entity) throws PSQLException;
    public List<T> readAllList();
    public T read(T entity);
    public void update(T entity);
    public void delete(T entity);
}
