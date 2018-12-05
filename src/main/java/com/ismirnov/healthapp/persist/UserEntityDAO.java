package com.ismirnov.healthapp.persist;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserEntityDAO implements UserDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        sessionFactory = sf;
    }

    @Override
    public UserEntity searchById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        UserEntity u = session.get(UserEntity.class, id);
        t.commit();
        return u;
    }

    @Override
    public UserEntity findByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.add(Restrictions.eq("email", email));
        UserEntity u = (UserEntity) criteria.uniqueResult();
        t.commit();
        return u;
    }
}
