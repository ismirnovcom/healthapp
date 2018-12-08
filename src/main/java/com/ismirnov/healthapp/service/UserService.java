package com.ismirnov.healthapp.service;

import com.ismirnov.healthapp.persist.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getByEmail(String email);

    UserEntity save(UserEntity user);

    UserEntity doesUserExist(String email);
}
