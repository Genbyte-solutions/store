package com.example.demo.model.dto;

import com.example.demo.model.enums.Rol;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
public class UserDto implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private Rol rol;

    public UserDto(Integer userId, String username, String password, Rol rol) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
}
