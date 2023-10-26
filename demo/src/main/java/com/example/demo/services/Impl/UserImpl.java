package com.example.demo.services.Impl;

import com.example.demo.model.entities.User;
import com.example.demo.repository.UserRespository;
import com.example.demo.services.IUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserImpl implements IUser {

    private final UserRespository userRespository;

    public UserImpl(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Transactional
    @Override
    public User save(User user) {
        return userRespository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRespository.findByUsernameAndPassword(username, password);
    }

}
