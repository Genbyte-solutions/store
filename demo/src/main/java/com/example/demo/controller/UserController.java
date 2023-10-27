package com.example.demo.controller;

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

    public UserController(IUser userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        User newUser = userService.save(userDto);
        userDto = UserDto.builder()
                .userId(newUser.getUserId())
                .username(newUser.getUsername())
                .password(newUser.getPassword())
                .rol(newUser.getRol())
                .build();
        return new ResponseEntity<>(ResponseMessage.builder()
                .message("A new user has been created")
                .object(userDto)
                .build(), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserDto userRecibido) {
        User session = userService.findByUsernameAndPassword(userRecibido.getUsername(), userRecibido.getPassword());

        if (session != null) {
            return new ResponseEntity<>(ResponseMessage.builder()
                    .message("Signed")
                    .object(session)
                    .build(), HttpStatus.OK);
        }

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Username or password is incorrect")
                .build(), HttpStatus.UNAUTHORIZED);
    }
}
