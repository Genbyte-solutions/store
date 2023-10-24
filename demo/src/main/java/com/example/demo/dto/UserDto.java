package com.example.demo.dto;

import com.example.demo.model.enums.Rol;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class UserDto implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private Rol rol;
}
