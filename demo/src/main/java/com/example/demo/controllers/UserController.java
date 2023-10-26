package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.model.entities.User;
import com.example.demo.services.IUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final IUser userService;

    public UserController(IUser userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/signin")
    public UserDto signIn(@RequestBody User userRecibido) {
        User user = userService.findByUsernameAndPassword(userRecibido.getUsername(), userRecibido.getPassword());
        return new UserDto(user.getUserId(),user.getRol());
    }
}
