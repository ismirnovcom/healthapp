package com.ismirnov.healthapp.repositories;

import com.ismirnov.healthapp.persist.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserEntityDAO implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public UserEntityDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity searchById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity u = session.get(UserEntity.class, id);
        return u;
    }

    @Override
    public UserEntity findByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.add(Restrictions.eq("email", email));
        UserEntity u = (UserEntity) criteria.uniqueResult();
        return u;
    }
}
