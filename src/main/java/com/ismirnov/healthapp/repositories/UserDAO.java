package com.ismirnov.healthapp.repositories;

import com.ismirnov.healthapp.persist.UserEntity;

public interface UserDAO {
    public UserEntity searchById(Integer id);
    public UserEntity findByEmail(String email);
}