package com.example.demo.model.dto;
import com.example.demo.model.enums.Rol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDtoTest {

    @Test
    public void testConstructor() {
        Integer userId = 1;
        String username = "user123";
        String password = "password123";
        Rol rol = Rol.EMPLEADO;

        UserDto userDto = new UserDto(userId, username, password, rol);

        assertNotNull(userDto);
        assertEquals(userId, userDto.getUserId());
        assertEquals(username, userDto.getUsername());
        assertEquals(password, userDto.getPassword());
        assertEquals(rol, userDto.getRol());
    }

    @Test
    public void testBuilder() {
        Integer userId = 2;
        String username = "user456";
        String password = "password456";
        Rol rol = Rol.ADMINISTRADOR;

        UserDto userDto = UserDto.builder()
                .userId(userId)
                .username(username)
                .password(password)
                .rol(rol)
                .build();

        assertNotNull(userDto);
        assertEquals(userId, userDto.getUserId());
        assertEquals(username, userDto.getUsername());
        assertEquals(password, userDto.getPassword());
        assertEquals(rol, userDto.getRol());
    }
}