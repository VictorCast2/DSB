package com.DevSalud.DSB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Repository.UserRepository;
import com.DevSalud.DSB.Service.UserServices;

public class UserServicesTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServices userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(new UserModel()));
        List<UserModel> users = userService.getAllUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    public void testSaveOrUpdateUsers() {
        UserModel user = new UserModel();
        userService.saveOrUpdateUsers(user);
        verify(userRepository).save(user);
    }

    @Test
    public void testGetUserById() {
        UserModel user = new UserModel();
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        UserModel foundUser = userService.getUserById(1L);
        assertNotNull(foundUser);
    }

    @Test
    public void testDeleteUserById() {
        userService.deleteUserById(1L);
        verify(userRepository).deleteById(1L);
    }

    @Test
    public void testOlvidarContrasenna() {
        UserModel user = new UserModel();
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        userService.olvidarContrasenna(1L, "newPassword");
        verify(userRepository).save(user);
    }
}