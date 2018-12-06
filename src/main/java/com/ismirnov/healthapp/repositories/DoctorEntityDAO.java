package com.ismirnov.healthapp.repositories;

import com.ismirnov.healthapp.persist.DoctorEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class DoctorEntityDAO implements DoctorDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public DoctorEntityDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DoctorEntity> findBySpecialityCode(String speciality) {
        EntityManager em = sessionFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DoctorEntity> doctorByIdCriteria = cb.createQuery(DoctorEntity.class);
        Root<DoctorEntity> doctorRoot = doctorByIdCriteria.from(DoctorEntity.class);
        doctorByIdCriteria.select(doctorRoot);
        doctorByIdCriteria.where(cb.equal(cb.lower(doctorRoot.get("specialityCode")), speciality.toLowerCase()));
        return em.createQuery(doctorByIdCriteria).getResultList();
    }
}
