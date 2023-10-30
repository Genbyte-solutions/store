package com.example.demo.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);
}
