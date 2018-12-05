package com.ismirnov.healthapp.service;

import com.ismirnov.healthapp.persist.UserDAO;
import com.ismirnov.healthapp.persist.UserEntity;
import com.ismirnov.healthapp.persist.UserEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
    public UserEntity getByEmail(String email) {
        return this.dao.findByEmail(email);
    }
}
