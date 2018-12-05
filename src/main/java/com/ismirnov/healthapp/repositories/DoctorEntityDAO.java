package com.ismirnov.healthapp.repositories;

import com.ismirnov.healthapp.persist.DoctorEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorEntityDAO implements DoctorDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public DoctorEntityDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public DoctorEntity findBySpeciality(String speciality) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(DoctorEntity.class);
        criteria.add(Restrictions.eq("specialityCode", speciality));
        return (DoctorEntity) criteria.uniqueResult();
    }
}
