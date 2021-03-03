package DAO;

import org.hibernate.JDBCException;
import org.postgresql.util.PSQLException;

import java.util.List;

public interface GenericDAO<T, V> {
    public void create(T entity) throws PSQLException;
    public List<T> readEntityList();
    public List<T> readEntityList(V v);
    public T read(T entity);
    public void update(T entity);
    public void delete(T entity);
}
