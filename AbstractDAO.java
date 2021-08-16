package dao;


import java.util.List;

public abstract class AbstractDAO<E, K> {


    public abstract List<E> getAll();

    public abstract E findEntityById(K id);

    public abstract E update(E entity);

    public abstract boolean delete(K id);

    public abstract boolean create(E entity);



}
