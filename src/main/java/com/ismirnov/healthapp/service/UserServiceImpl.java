package com.ismirnov.healthapp.service;

import com.ismirnov.healthapp.repositories.UserDAO;
import com.ismirnov.healthapp.persist.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
    UserDAO dao;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.dao = userDAO;
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<UserEntity> getByEmail(String email) {
        return this.dao.findByEmail(email);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return dao.save(user);
    }

    @Override
    public UserEntity doesUserExist(String email) {
        List<UserEntity> users = dao.findByEmail(email);
        if (users.size() > 0) {
            users.get(0);
        }
        return null;
    }
}
