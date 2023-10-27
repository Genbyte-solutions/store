package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.User;
import com.example.demo.model.payload.ResponseMessage;
import com.example.demo.service.IUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final IUser userService;
    private final UserMapper userMapper;

    public UserController(IUser userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        User newUser = userService.save(userDto);

        userDto = userMapper.toDTO(newUser);

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("A new user has been created")
                .object(userDto)
                .build(), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserDto userRecibido) {
        User user = userService.findByUsernameAndPassword(userRecibido.getUsername(), userRecibido.getPassword());

        UserDto userDto = userMapper.toDTO(user);

        if (user != null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Signed")
                    .object(userDto)
                    .build(), HttpStatus.OK);
        }

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Username or password is incorrect")
                .build(), HttpStatus.UNAUTHORIZED);
    }
}
