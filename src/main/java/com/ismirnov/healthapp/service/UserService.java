package com.ismirnov.healthapp.service;

import com.ismirnov.healthapp.persist.UserEntity;

public interface UserService {
    UserEntity getByEmail(String email);
}
