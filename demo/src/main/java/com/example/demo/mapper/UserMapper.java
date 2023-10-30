package com.example.demo.mapper;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDTO(User user);
}
