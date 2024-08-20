package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.model.User;
import com.anantmathur.tablebookingapp.repository.UserRepository;
import com.anantmathur.tablebookingapp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        User user = new User(1L, "John Doe", "john@example.com", "password", "1234567890", "123 Main St");
        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.addUser(user);
        assertNotNull(createdUser);
        assertEquals("John Doe", createdUser.getUserName());
    }

    @Test
    void testGetUserById() {
        User user = new User(1L, "John Doe", "john@example.com", "password", "1234567890", "123 Main St");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.getUserById(1L);
        assertTrue(foundUser.isPresent());
        assertEquals("John Doe", foundUser.get().getUserName());
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;
        userService.deleteUser(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }
}
