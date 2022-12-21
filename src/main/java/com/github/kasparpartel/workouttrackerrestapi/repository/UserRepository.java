package com.github.kasparpartel.workouttrackerrestapi.repository;

import com.github.kasparpartel.workouttrackerrestapi.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void save(User user);
}
