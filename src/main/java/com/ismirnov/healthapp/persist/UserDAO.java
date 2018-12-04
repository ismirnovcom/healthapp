package com.ismirnov.healthapp.persist;

public interface UserDAO {
    public UserEntity searchById(Integer id);
    public UserEntity getByEmail(String email);
}