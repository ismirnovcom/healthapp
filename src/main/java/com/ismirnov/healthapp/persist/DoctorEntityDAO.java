package com.ismirnov.healthapp.persist;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class DoctorEntityDAO implements DoctorDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        sessionFactory = sf;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public DoctorEntity findBySpeciality(String speciality) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(DoctorEntity.class);
        criteria.add(Restrictions.eq("specialityCode", speciality));
        return (DoctorEntity) criteria.uniqueResult();
    }
}
