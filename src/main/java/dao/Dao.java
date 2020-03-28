package dao;

import java.util.List;

import exception.DataBaseException;

public interface Dao<T> {

    T get(Long id) throws DataBaseException;

    List<T> getAll() throws DataBaseException;

    void save(T t) throws DataBaseException;

    void update(T t, String[] params) throws DataBaseException;

    void delete(T t) throws DataBaseException;
}