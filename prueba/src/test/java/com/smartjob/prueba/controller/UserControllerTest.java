package com.smartjob.prueba.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.smartjob.prueba.dto.UserRequestDTO;
import com.smartjob.prueba.model.User;
import com.smartjob.prueba.service.UserService;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser_Success() {
        // Configurar el mock
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("hunter2");

        User user = new User();
        user.setName("Juan");
        user.setEmail("juan@rodriguez.org");

        when(userService.registerUser(any(UserRequestDTO.class))).thenReturn(user);

        // Llamar al método a probar
        ResponseEntity<?> responseEntity = userController.registerUser(userRequestDTO);

        // Verificar el resultado
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

    
    @Test
    void registerUser_BadRequest() {
        // Configurar el mock para lanzar una excepción
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("hunter2");

        doThrow(new IllegalArgumentException("El usuario ya existe")).when(userService).registerUser(any(UserRequestDTO.class));

        // Llamar al método a probar
        ResponseEntity<?> responseEntity = userController.registerUser(userRequestDTO);

        // Verificar el resultado
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(Collections.singletonMap("mensaje", "El usuario ya existe"), responseEntity.getBody());
    }
    
}
