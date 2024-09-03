package com.smartjob.prueba.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.smartjob.prueba.dto.UserRequestDTO;
import com.smartjob.prueba.exception.EmailAlreadyRegisteredException;
import com.smartjob.prueba.model.User;
import com.smartjob.prueba.service.UserService;

class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
    void registerUser_BadRequest_Exception() {
        // Configurar el mock para lanzar una excepción personalizada
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("hunter2");
    
        // Simula que el servicio lanza EmailAlreadyRegisteredException
        when(userService.registerUser(any())).thenThrow(new EmailAlreadyRegisteredException("El email ya se encuentra registrado"));
    
        // Verificar que se lanza la excepción
        EmailAlreadyRegisteredException thrown = assertThrows(
            EmailAlreadyRegisteredException.class,
            () -> userController.registerUser(userRequestDTO)
        );
    
        // Verificar el mensaje de la excepción
        assertEquals("El email ya se encuentra registrado", thrown.getMessage());
    }
        
    
}
