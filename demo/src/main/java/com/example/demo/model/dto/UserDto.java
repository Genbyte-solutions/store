package com.example.demo.model.dto;

import com.example.demo.model.enums.Rol;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
@AllArgsConstructor
public class UserDto implements Serializable {
    private Integer userId;
    private String username;
    private String password;
    private Rol rol;
}
