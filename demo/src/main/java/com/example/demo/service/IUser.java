package com.example.demo.service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;

public interface IUser {
    User save(UserDto user);

    User findByUsernameAndPassword(String username, String password);
}
