package com.example.demo.mapper;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class UserMapper {

    public UserDto toDTO(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .rol(user.getRol())
                .build();
    }
}
