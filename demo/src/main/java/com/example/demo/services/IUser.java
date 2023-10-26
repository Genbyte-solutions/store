package com.example.demo.services;

import com.example.demo.model.entities.User;

public interface IUser {
    User save(User user);

    User findByUsernameAndPassword(String username, String password);
}
