package io.indorse.test.authentication.dao.impl;

import io.indorse.test.authentication.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository
public class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public GenericDaoImpl(){
    }

    public GenericDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public T find(Class<T> type, Integer id) {
        return (T) sessionFactory.getCurrentSession().get(type, id);

    }

    @Transactional
    public List<T> findAll(Class<T> type) {
        return sessionFactory.getCurrentSession().createCriteria(type).list();
    }

    @Transactional
    public T save(T t) {
        return (T) sessionFactory.getCurrentSession().save(t);

    }

    @Transactional
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);

    }

    @Transactional
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);

    }

    @Transactional
    @Override
    public List<T> findBy(Class<T> type, List<Criterion> criterions) {
        List<T> ts;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(type);
        for (Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        ts = criteria.list();

        return ts;
    }
}
