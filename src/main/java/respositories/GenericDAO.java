package respositories;

import java.util.List;

public interface GenericDAO<T> {
    void create(T object) throws Exception;

    void delete(T object) throws Exception;

    List<T> getAll() throws Exception;

    T getById(int id) throws Exception;

    void update(T object) throws Exception;

}
