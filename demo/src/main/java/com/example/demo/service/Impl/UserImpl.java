package com.example.demo.service.Impl;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRespository;
import com.example.demo.service.IUser;
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
    public User save(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .rol(userDto.getRol())
                .build();
        return userRespository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRespository.findByUsernameAndPassword(username, password);
    }

}
