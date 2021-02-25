package DAO;

import java.util.List;

public interface GenericDao<T> {
    public void create(T entity);
    public List<T> readAllList();
    public T read(T entity);
    public void update(T entity);
    public void delete(T entity);
}
