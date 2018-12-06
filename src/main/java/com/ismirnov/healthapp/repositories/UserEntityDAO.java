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

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

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
        return session.get(UserEntity.class, id);
    }

    @Override
    public List<UserEntity> findByEmail(String email) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> userCriteria = cb.createQuery(UserEntity.class);
        userCriteria.from(UserEntity.class);
        return em.createQuery(userCriteria).getResultList();
    }
}
