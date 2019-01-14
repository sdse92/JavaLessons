package dao;

import java.util.List;

public interface Dao {
    void add(Object o);
    void delete(int id);
    void update(int id, Object o);
    List<Object> getAll();
    Object getById(int id);
}
