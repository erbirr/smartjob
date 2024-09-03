package com.smartjob.prueba.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.smartjob.prueba.dto.PhoneDTO;
import com.smartjob.prueba.dto.UserRequestDTO;
import com.smartjob.prueba.exception.EmailAlreadyRegisteredException;
import com.smartjob.prueba.model.User;
import com.smartjob.prueba.repository.UserRepository;
import com.smartjob.prueba.service.UserService;

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
    void registerUser_ShouldSaveAndReturnUser_WhenDataIsValid() {
        // Arrange
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("hunter2");
        
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setNumber("1234567");
        phoneDTO.setCitycode("1");
        phoneDTO.setContrycode("57");
        
        userRequestDTO.setPhones(Collections.singletonList(phoneDTO));

        User savedUser = new User();
        savedUser.setId(UUID.randomUUID());
        savedUser.setName(userRequestDTO.getName());
        savedUser.setEmail(userRequestDTO.getEmail());
        savedUser.setPassword(userRequestDTO.getPassword());
        savedUser.setToken("fake-token");
        savedUser.setActive(true);

        when(userRepository.findByEmail(userRequestDTO.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        User result = userService.registerUser(userRequestDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Juan Rodriguez", result.getName());
        assertEquals("juan@rodriguez.org", result.getEmail());
        assertTrue(result.isActive());
        assertNotNull(result.getToken());
    }

    @Test
    void registerUser_ShouldThrowException_WhenEmailAlreadyExists() {
        // Arrange
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("hunter2");

        when(userRepository.findByEmail(userRequestDTO.getEmail())).thenReturn(Optional.of(new User()));

        // Act & Assert
        EmailAlreadyRegisteredException exception = assertThrows(EmailAlreadyRegisteredException.class, () -> {
            userService.registerUser(userRequestDTO);
        });

        assertEquals("El email ya se encuentra registrado", exception.getMessage());
    }


}
