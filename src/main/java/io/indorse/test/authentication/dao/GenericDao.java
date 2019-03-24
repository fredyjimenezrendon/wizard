package io.indorse.test.authentication.dao;

import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable> {

    T find(final Class<T> type, final Integer id);
    List<T> findAll(final Class<T> type);
    T save(final T t);
    void update(final T t);
    void delete(final T t);
    List<T> findBy(final Class<T> type, final List<Criterion> criterions);

}
