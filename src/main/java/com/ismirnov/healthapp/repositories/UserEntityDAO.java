package com.ismirnov.healthapp.repositories;

import com.ismirnov.healthapp.persist.UserEntity;
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
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
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
    @Transactional
    public UserEntity save(UserEntity user) {
        Session s = this.sessionFactory.getCurrentSession();
        s.save(user);
        return user;
    }

    @Override
    public List<UserEntity> findByEmail(String email) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> userByIdCriteria = cb.createQuery(UserEntity.class);
        Root<UserEntity> userRoot = userByIdCriteria.from(UserEntity.class);
        userByIdCriteria.select(userRoot);
        userByIdCriteria.where(cb.equal(cb.lower(userRoot.get("email")), email.toLowerCase()));
        return em.createQuery(userByIdCriteria).getResultList();
    }

}
