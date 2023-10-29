package com.example.demo.model.entities;
import com.example.demo.model.enums.Rol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = User.builder()
                .userId(1)
                .username("john_doe")
                .password("password123")
                .rol(Rol.ADMINISTRADOR)
                .build();
    }

    @Test
    public void testUserId() {
        assertEquals(1, user.getUserId());
    }

    @Test
    public void testUsername() {
        assertEquals("john_doe", user.getUsername());
    }

    @Test
    public void testPassword() {
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testRol() {
        assertEquals(Rol.ADMINISTRADOR, user.getRol());
    }

    @Test
    public void testToString() {
        String expectedToString = "User(userId=1, username=john_doe, password=password123, rol=ADMINISTRADOR)";
        assertEquals(expectedToString, user.toString());
    }

    @Test
    public void testNoArgsConstructor() {
        User newUser = new User();
        assertNotNull(newUser);
    }

    @Test
    public void testAllArgsConstructor() {
        User anotherUser = new User(2, "jane_doe", "pass456", Rol.ADMINISTRADOR);
        assertNotNull(anotherUser);
    }
}