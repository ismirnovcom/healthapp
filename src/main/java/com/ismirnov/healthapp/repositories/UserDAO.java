package com.ismirnov.healthapp.repositories;

import com.ismirnov.healthapp.persist.UserEntity;

import java.util.List;

public interface UserDAO {
    public UserEntity searchById(Integer id);

    UserEntity save(UserEntity user);

    public List<UserEntity> findByEmail(String email);
}